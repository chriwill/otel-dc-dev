# ODCD (OpenTelemetry Data Collector Divers) 

**[Semantic Convention](docs/semconv)** |
**[Changelog](CHANGELOG.md)** |
**[Contributing](CONTRIBUTING.md)** |
**[License](LICENSE)**

---
ODCD (OpenTelemetry Data Collector Divers) is a collection of stanalone OpenTelemetry receivers for databases, systems, apps, ant etc. All implementations are based on predefined OpenTelemetry Semantic Conventions. A standard OTLP exporter is provided to forward the data from this "Data Collector" to a Telemetry backend or an OpenTelemetry Collector.
<br>


## Data Collectors provided

- [OTel Data Collectors for Relational Databases](rdb/README.md) (**Java 8+**)
- [OTel Data Collectors for Host](host/README.md) (**Java 11+**)
- [OTel Data Collectors for LLM](llm/README.md) (**Java 11+**)


## Common Parameters for Data Collectors

| Parameter                 | Scope     | Description                                                                                                           | Example                |
|---------------------------|-----------|-----------------------------------------------------------------------------------------------------------------------|------------------------|
| otel.backend.url          | instance  | The otlp URL of the OTel Backend. E.g., http://localhost:4317 (grpc) or http://localhost:4318/v1/metrics (http)       | http://127.0.0.1:4317  |  
| otel.backend.using.http   | instance  | false (default, using otlp/grpc) or true (using otlp/http)                                                            | false                  |  
| otel.service.name         | instance  | The OTel Service name (It is requred by OTel)                                                                         | DamengDC               |  
| otel.service.instance.id  | instance  | The OTel Service instance ID (which is ID of this database entity. It can be generated by DC if it is not provided)   | 1.2.3.4:5236@MYDB      |  
| poll.interval             | instance  | The time interval in seconds to query metrics                                                                         | 25                     |  
| callback.interval         | instance  | The time interval in seconds to post data to backend                                                                  | 30                     |  
