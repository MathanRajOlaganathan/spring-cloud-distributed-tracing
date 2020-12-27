# **Distributed Tracing**
> Distributed tracing is a technique to monitor and profile the applications, especially those built using microservice architecture. It is also known as distributed request tracing. Developers use distributed tracing to debug and optimize the code.

### Sleuth
> Sleuth is a tool from Spring cloud family. It is used to generate the trace id, span id and add these information to the service calls in the headers and MDC, so that It can be used by tools like Zipkin and ELK etc. to store, index and process log files

As it is from spring cloud family, once added to the CLASSPATH, it automatically integrated to the common communication channels like –

* requests made with the RestTemplate etc.
* requests that pass through a Netflix Zuul microproxy
* HTTP headers received at Spring MVC controllers
* requests over messaging technologies like Apache Kafka or RabbitMQ etc.

* Artifact : **spring-cloud-starter-sleuth**

The **Spring Cloud Sleuth token** has the following components:

_Application name:_ The name of the application that is defined in the properties file.
_Trace Id_: The Sleuth adds the Trace Id. It remains the same in all services for a given request.
_Span Id_: The Sleuth also adds the Span Id. It remains the same in a unit of work but different for different services for a given request.
_Zipkin Export Flag_: It indicates a boolean value. It can be either true or false.

- If we want to trace all the requests, we would need to create ALWAYS_SAMPLE. We can create a Sampler by using a Bean.

### Zipkin
> Zipkin is a distributed tracing system. It helps gather timing data needed to troubleshoot latency problems in service architectures
- Zipkin is an open-source, Java-based distributed tracing system. It has a management console that provides a mechanism for sending, receiving, storing, and visualizing traces details of the subsequent services.

##### Components:
Internally it has 4 modules –

1. _Collector_ – Once any component sends the trace data arrives to Zipkin collector daemon, it is validated, stored, and indexed for lookups by the Zipkin collector.
2. _Storage_ – This module store and index the lookup data in backend. Cassandra, ElasticSearch and MySQL are supported.
3. _Search_ – This module provides a simple JSON API for finding and retrieving traces stored in backend. The primary consumer of this API is the Web UI.
4. _Web UI_ – A very nice UI interface for viewing traces.

_Install Zipkin_:

1. `Docker - docker run -d -p 9411:9411 openzipkin/zipkin`

2. `curl -sSL https://zipkin.io/quickstart.sh | bash -s
   java -jar zipkin.jar`

 we can see the Web UI at (http://localhost:9411/zipkin/)
 
 To install Zipkin in spring boot application - **spring-cloud-starter-zipkin**
 
 * Once Sleuth is enabled, we can see the logs with the trace id, but in order to track the whole reqeust,
 it is difficult since it is distributed, so we need a distributed logging.
 
 * There are the following solutions for centralize logging:
 
 1. ELK Stack (Elastic Search)
 2. Kibana
 3. Zipkin
 
_gaming-client_:[GAMING-CLIENT,737d902fe950bffd,737d902fe950bffd,true] 11876 --- [nio-8080-exec-6] c.g.client.controller.GamingController   : GamingController
_gaming-service_:[GAMING-SERVICE,737d902fe950bffd,ce1452c71593ddf0,true] 13888 --- [nio-9092-exec-3] c.g.s.c.GamingServiceController          : GamingServiceController
 
 