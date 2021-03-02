package ru.konstantin.check_item_price

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.request.*
import io.ktor.client.statement.*
import org.junit.Test
import ru.konstantin.check_item_price.shops.yandex_market.YandexMarket


//@SpringBootTest
class CheckItemPriceApplicationTests {

    @Test
    fun contextLoads() {
    }

//    @Test
//    fun testYandexProducts() {
//        val yandex = YandexMarket()
//        yandex.run()
//    }

//    @Test
//    suspend fun testHttpClient() {
//        // Create socks proxy
//        val httpProxy = ProxyBuilder.http("http://103.78.55.113:8080")
//        val client = HttpClient(CIO) {
//            engine {
////                proxy = httpProxy
//            }
//            install(HttpTimeout) {
//                // timeout config
//                requestTimeoutMillis = 10000
//            }
//        }
//
//        val response = client.get<HttpResponse>("https://market.yandex.ru/catalog--literatura-o-kompiuterakh-i-internete-dlia-nachinaiushchikh/18071431/list?hid=90874")
//        println()
//    }
}
