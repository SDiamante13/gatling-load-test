import io.gatling.core.Predef._
import io.gatling.http.Predef._

class AsyncSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://localhost:8082/sink/reactive/")
    .acceptHeader("application/json")

  val scenario1 = scenario("Get to Sink 1")
    .exec(http("request_1")
      .get("HDDBD33229TR3")
    )

  val scenario2 = scenario("Get to Sink 2")
    .exec(http("request_2")
      .get("KCH-1000")
    )

  val scenario3 = scenario("Get to Sink 3")
    .exec(http("request_3")
      .get("VT3322G2")
    )

  setUp(
    scenario1.inject(atOnceUsers(1000)),
    scenario2.pause(1).inject(atOnceUsers(1000)),
    scenario3.pause(1).inject(atOnceUsers(1000))
  ).protocols(httpConf)

}
