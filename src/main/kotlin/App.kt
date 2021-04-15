import org.apache.camel.builder.RouteBuilder
import org.apache.camel.impl.DefaultCamelContext

class App {
    fun run() {
        DefaultCamelContext().use { camel ->
            camel.addRoutes(object : RouteBuilder() {
                override fun configure() {
                    from("netty:udp://0.0.0.0:5155")
                        .multicast().parallelProcessing().to("log:result", "netty:udp://127.0.0.1:5160", "netty:udp://127.0.0.1:5165")
                }
            })
            camel.start()
            Thread.sleep(10000000)
            camel.stop()
        }
    }
}