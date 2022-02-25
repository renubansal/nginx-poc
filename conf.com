server {
 	proxy_cache_path ~/Downloads/logs levels=1:2 keys_zone=my_zone:10m inactive=60m;
    proxy_cache_key "$scheme$request_method$host$request_uri|$request_body";
        listen     80;
        listen [::]:80;
        server_name  _;

        location / {
           proxy_pass        http://localhost:8080;

           proxy_set_header  X-Real-IP $remote_addr;
           proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
           proxy_set_header  Host $http_host;

           proxy_cache my_zone;
           add_header X-Proxy-Cache $upstream_cache_status;
           proxy_ignore_headers Cache-Control;

           proxy_cache_methods GET HEAD POST;
           proxy_cache_valid any 48h;
           proxy_cache_bypass $bypass;
        }
    }