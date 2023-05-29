psql -h 127.0.01 -p 3307 -d sharding_db -U root

scp config/v1/config-sharding.yaml root@sharding001:/usr/local/shardingsphere/apache-shardingsphere-5.3.2-shardingsphere-proxy-bin/conf