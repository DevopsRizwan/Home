#
# Cookbook Name:: jenkins
# HWRP:: plugin
# Modified by: Tapas K. Chowdhury <tapas.chowdhury@cognizant.com>
# Author:: Seth Vargo <sethvargo@gmail.com>
# Author:: Seth Chisamore <schisamo@chef.io>
#
# Copyright 2013-2014, Chef Software, Inc.

require_relative '_helper'

class Chef
  class Resource::JenkinsPlugin < Resource::LWRPBase
    # Chef attributes
    identity_attr :name
    provides :jenkins_plugin

    # Set the resource name
    self.resource_name = :jenkins_plugin

    # Actions
    actions :install 
    default_action :install

    # Attributes
    attribute :name,
      kind_of: String,
      name_attribute: true
    attribute :version,
      kind_of: [String, Symbol],
      default: :latest
    attribute :source,
      kind_of: String
    attribute :options,
      kind_of: String

    attr_writer :installed

    #
    # Determine if the plugin is installed on the master. This value is set by
    # the provider when the current resource is loaded.
    #
    # @return [Boolean]
    #
    def installed?
      !!@installed
    end
  end
end

class Chef
  class Provider::JenkinsPlugin < Provider::LWRPBase
  include Jenkins::Helper

  def load_current_resource
      @current_resource ||= Resource::JenkinsPlugin.new(new_resource.name)
      @current_resource.source(new_resource.source)
      @current_resource.version(new_resource.version)

      if current_plugin
        @current_resource.installed = true
        @current_resource.version(current_plugin[:plugin_version])
      else
        @current_resource.installed = false
      end

      @current_resource
    end


    action(:install) do
      # This block stores the actual command to execute, since its the same
      # for upgrades and installs.
      block = proc do
        # Install a plugin from a given hpi (or jpi) if a link was provided.
        # In that case jenkins does not handle plugin dependencies automatically.
        # Otherwise the plugin is installed through the jenkins update-center
        # (default behaviour). In that case plugin dependencies are handled by jenkins.
        if new_resource.source
          # Use the remote_file resource to download and cache the plugin (see
          # comment below for more information).
          name   = "#{new_resource.name}-#{new_resource.version}.plugin"
          path   = ::File.join(Chef::Config[:file_cache_path], name)
          plugin = Chef::Resource::RemoteFile.new(path, run_context)
          plugin.source(new_resource.source)
          plugin.backup(false)
          plugin.run_action(:create)

          # Install the plugin from our local cache on disk. There is a bug in
          # Jenkins that prevents Jenkins from following 302 redirects, so we
          # use Chef to download the plugin and then use Jenkins to install it.
          # It's a bit backwards, but so is Jenkins.
          executor.execute!('install-plugin', escape(plugin.path), '-name', escape(new_resource.name), new_resource.options)
        else
          # Install the plugin from the update-center. This results in the
          # same behaviour as using the UI to install plugins.
          executor.execute!('install-plugin', escape(new_resource.name), new_resource.options)
        end
      end

     if current_resource.installed?
        if current_resource.version == new_resource.version ||
           new_resource.version.to_sym == :latest
          Chef::Log.debug("#{new_resource} already installed - skipping")
        else
          converge_by("Upgrade #{new_resource} from #{current_resource.version} to #{new_resource.version}", &block)
        end
      else
        converge_by("Install #{new_resource}", &block)
      end
    end


    #
    # Loads the local plugin into a hash
    #
    def current_plugin
      return @current_plugin if @current_plugin

      manifest = ::File.join(plugins_directory, new_resource.name, 'META-INF', 'MANIFEST.MF')
      Chef::Log.debug "Load #{new_resource} plugin information from #{manifest}"

      return nil unless ::File.exist?(manifest)

      @current_plugin = {}

      ::File.open(manifest, 'r', encoding: 'utf-8') do |file|
        file.each_line do |line|
          next if line.strip.empty?

          #
          # Example Data:
          #   Plugin-Version: 1.4
          #
          config, value = line.split(/:\s/, 2)
          config = config.gsub('-', '_').downcase.to_sym
          value = value.strip if value # remove trailing \r\n

          @current_plugin[config] = value
        end
      end
    end

 #
    # The path to the plugins directory on the Jenkins node.
    #
    # @return [String]
    #
    def plugins_directory
      ::File.join(node['jenkins']['master']['home'], 'plugins')
    end

    #
    # The path to the actual plugin file on disk (+.jpi+)
    #
    def plugin_file
      hpi = ::File.join(plugins_directory, "#{new_resource.name}.hpi")
      jpi = ::File.join(plugins_directory, "#{new_resource.name}.jpi")

      ::File.exist?(hpi) ? hpi : jpi
    end

    #
    # The path to where the plugin stores its data on disk.
    #
    def plugin_data_directory
      ::File.join(plugins_directory, new_resource.name)
    end
  end
end


Chef::Platform.set(
  resource: :jenkins_plugin,
  provider: Chef::Provider::JenkinsPlugin
)


