pubkey = node['ssh']['pubkey']
user "cmonitor" do
  supports :manage_home => true
  comment 'Cognizant Monitoring User'
  password '$1$b7VbWIkD$y6GFiGQsMCPc6uZ7u/Qy3.'
  shell '/bin/bash'
  action :create
end

user "cmanage" do
  supports :manage_home => true
  comment 'Cognizant Management User'
  password '$1$eSDzza.8$tumHEOczzRghqkuasg8vg1'
  shell '/bin/bash'
  action :create
end

user "cadmin" do 
  supports :manage_home => true
  comment 'Cognizant admin User'
  password '$1$xeyG15EL$X91O/nTl/xohJdfqOGKOF/'
  shell '/bin/bash'
  action :create
end

user "cbackup" do
  supports :manage_home => true
  comment 'Cognizant backup User'
  password '$1$F6HUpqOZ$leQuMZo9YOIrf8fd7OuLh.'
  shell '/bin/bash'
  action :create
end

%w(cmonitor cmanage cadmin cbackup).each do |username|
  directory "/home/#{username}/.ssh" do
    owner username
    group username
  end
end

%w(cmonitor cmanage cadmin cbackup).each do |username|
  cookbook_file "#{pubkey}" do
    path "/home/#{username}/.ssh/authorized_keys"
    action :create_if_missing
    owner username
    group username
    mode '0600'
  end
end
