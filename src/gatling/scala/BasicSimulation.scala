import io.gatling.http.Predef._
import io.gatling.core.Predef._

class BasicSimulation extends Simulation {
  val httpConf = http.baseURL("http://localhost:8082/sink/")
  val scn = scenario("Basic Simulation")
    .exec(http("request_1")
      .get("HDDBD33229TR3"))
    .pause(5)
  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)
}
