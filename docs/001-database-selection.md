# NOSQL database selection for [Chegura project](https://github.com/Scorpibear/chegura)

* Status: __DECIDED__
* Date: 21-03-2021

## PROBLEM

- Need to define appropriate database for Chegura project

## SOLUTION OPTIONS
- Redis
- AmazonDynamoDB
- MongoDB
- Apache Cassandra
- Neo4j

### Redis 
#### Pros:
- Exceptional performance for read/write operations
- Has flexible data structures, it supports almost all data structures.
- High availability due to build in support for asynchronous, non-blocking replication
- Zero downtime or performance impact while scaling up or down.
- Lightweight with no external dependencies
- Sharding
#### Cons:
- The whole dataset always resides in RAM.Not suitable for long data storing
- Memory fragmentation issues. Writing and deleting huge amounts of data may result in performance degradation.
- Clients connecting to the Redis cluster should be aware of the cluster topology, causing overhead configuration on Clients.
- Failover does not happen unless the master has at least one slave.
- __Prohibited to use according to task conditions__

### Amazon DynamoDB
#### Pros:
- Simple setup
- Virtual unlimited storage, users can store infinity amount of data according to their need
- DynamoDB scales horizontally by expanding a single table over multiple servers
- DynamoDB supports streams, allowing other systems to react to data changes.
- Time to live support
- Amazon DynamoDB supports ACID transactions
#### Cons:
- Weak querying model(Global and Secondary Indexes can only get us so far. Should know your access patterns)
- Joins are impossible, Triggerless. With DynamoDB, you can only provision its capacity at the entire table level
- __Prohibited to use according to task conditions__

### MongoDB
#### Pros:
- MongoDB stores documents in collections which are analogous to relational database
- Supports read only views
- Supports Ad-hoc queries and indexes(any field can be indexed)
- High Availability(replication, auto failover, data redundancy)
- Horizontal Scalability
- Sharding
- MongoDB supports multi-document ACID transactions
#### Cons:
- Joining documents in MongoDB can be a very tedious task. It fails to support joins as a relational database.
- Limited Data Size and Nesting
- High Memory Usage
- Indexing(High performance is only possible with the right indexes. With shoddily implemented indexes MongoDB will operate at a shockingly slow speed.)

### Apache Cassandra
#### Pros:
- Distributed(asynchronous masterless replication)
- Highly scalable and highly available with no single point of failure.
- Fault-tolerant(data automatically replicated to multiple nodes, failed nodes can be replaced without downtime)
- Flexible schema.
- SQL-like query language and support search through secondary indexes.
- Tunable consistency and support for replication.
- NoSQL column family implementation.
#### Cons:
- No Support for ACID Properties(Cassandra does not provide ACID and relational data properties)
- Making excessive requests and reading more data slows down the actual transaction, resulting in latency issues.
- No join or subquery support.
- Data Duplication(Data is modeled around queries instead of its structure due to which same data is store multiple times)
- Slow Reads(Reads are slower. Cassandra was optimized from the beginning for fast writes)

### Neo4j
#### Pros:
- High availability(build for 24x7, five-nines operation)
- Easily scalable(Can be easily scalable as the number of read/write increases without any downtime)
- Data replication(Allows us to replicate the data into multiple servers, ultimately leading to data safety and reliability)
- Support Indexes(Supports Indexes with the help of Apache Lucence)
- No schema(Neo4j is a no SQL database, allowing us to insert the data with varying schema)
- Graph representation: With neo4j, we can easily represent the data in graphical format.
- Pretty fast as it can retrieve massive data in a few seconds.
- Neo4J supports ACID transactions
#### Cons:
- Sharding is not supported
- No native support for complex properties for nodes and relationships
- Only vertical scalability is possible.

## DECISION VARIABLES
- Database should provide data pretty fast and can retrieve massive data in a few seconds
- Database should support three-data structure
- Database should support ACID transactions

## DECISION RATIONALE 
- Why we make this? According to [CAP Consideration](https://www.geeksforgeeks.org/how-to-choose-the-right-database-for-your-application/) relational databases suits our needs better (Consistency and Availability are preferable options). Also we need good support of R2DBC Driver and PostgreSQL shows better performance with it.

## DECISION
- Going with Neo4J


