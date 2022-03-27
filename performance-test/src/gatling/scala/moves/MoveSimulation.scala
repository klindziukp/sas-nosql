package moves

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration.{FiniteDuration, SECONDS}

class MoveSimulation extends Simulation {

  private val headers = Map("Content-Type" -> "application/json")

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl("http://localhost:8080")

  val getMoves: ScenarioBuilder = scenario("Get all moves")
    .exec(http("Get all moves")
      .get("/moves")
    .check(status.is(200)))
    .pause(3,4)

    .exec(http("Get move by m ")
      .get("/moves/move/d1")
    .check(status.is(200)))
    .pause(3,4)

    .exec(http("Create Move")
    .post("/moves/save")
    .headers(headers)
    .body(PebbleFileBody("templates/create-move.peb"))
    .check(status.is(200)))

  setUp(getMoves.inject(
    constantUsersPerSec(1) during (FiniteDuration(10, SECONDS)))
    .protocols(httpProtocol))
}