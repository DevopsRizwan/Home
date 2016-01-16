ruby_block "set-env-java-home" do
  block do
   puts ENV['JAVA_HOME'] = '/usr/bin/java' 
  end
end
