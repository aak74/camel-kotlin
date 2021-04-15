# Multicast UDP using Kotlin and Apache Camel

If you need to send your messages to two or more servers. You may use this way.

## Preps 
- AppServer listen port 5155 and then send incoming messages to port 5160 and 5165. 
- Two another servers listen ports 5160 and 5165.
- Your message will be sent to server port 5155 and then forwarded to ports 5160 and 5165.

```sh
# Listen port 5160
while true; do nc -lvu 5160; done

# Listen port 5165
while true; do nc -lvu 5165; done

# Send message to port 5155
echo -n '{"version": "1.1","f":"foo","b":"bar"}' | nc -u -w1 127.0.0.1 5155
```
