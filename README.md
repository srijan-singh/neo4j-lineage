# Neo4j-Basics

## CYPHER Query

### CREATE

    CREATE 
    
    (node_a: LABEL_1 {attribute_x: "a_1", attribute_y: "a_2"}),
    (node_b: LABEL_1 {attribute_x: "b_1", attribute_y: "b_2"}),

    (node_c: LABEL_2 {attribute_x: "c_1", attribute_z: "c_3}),

    (node_d: LABEL_3 {attribute_x: "d_1"}),

    (node_a) -[:RELATIONSHIP_1]-> (node_b),
    (node_a) <-[:RELATIONSHIP_1]- (node_b),

    (node_c) -[:RELATIONSHIP_2]-> (node_a),
    (node_c) -[:RELATIONSHIP_2]-> (node_b),

    (node_a) -[:RELATIONSHIP_3 {attribute_p: a_100, attribute_q: a_200, attribute_r: a_300}]-> (node_d),
    (node_b) -[:RELATIONSHIP_3 {attribute_p: b_100, attribute_q: b_200, attribute_r: b_300}]-> (node_d),
    (node_c) -[:RELATIONSHIP_3 {attribute_c: c_100, attribute_q: c_200, attribute_r: c_300}]-> (node_d);

### READ

1. Read by LABEL

        // NODE
        MATCH (node:LABEL_1) 
        RETURN node

        // Attribute
        MATCH (node:LABEL_1) 
        RETURN node.attribute_1

2. Read by Node attributes

        // BASIC OPERATION

        // Equals
        MATCH (node:LABEL_1)
        WHERE node.attribute_1 = "X"
        RETURN node

        MATCH (node:LABEL_1 {attribute_1: "X"})
        RETURN node
    
        // Not Equal
        MATCH (node:LABEL_1)
        WHERE node.attribute_1 <> "X"
        RETURN node

        // Greater than
        MATCH (node:LABEL_1)
        WHERE node.attribute_1 >= 0 
        RETURN node

        // Less than
        MATCH (node:LABEL_1)
        WHERE node.attribute_1 <=10
        RETURN node

        // LOGIC OPERATION

        // OR
        MATCH (node:LABEL_1)
        WHERE node.attribute_1 = "X" OR node.attribute_2 = "Y"
        RETURN node

        // AND
        MATCH (node:LABEL_1)
        WHERE node.attribute_1 = "X" AND node.attribute_2 = "Y"
        RETURN node

        // NOT
        MATCH (node:LABEL_1)
        WHERE NOT node.attribute_1 = "X"
        RETURN node

        // STATS

        // Arithmetic operation
        MATCH (node:LABEL_1) 
        WHERE (node.attribute_1 / (node_attribute_2 * node_attribute_2)) > X
        RETURN node

        // LIMIT
        MATCH (node:LABEL_1)
        WHERE node.attribute >= X
        RETURN node
        LIMIT 1

        // SKIP
        MATCH (node:LABEL_1)
        WHERE node.attribute >= X
        RETURN node
        // Would skip the first node
        SKIP 1
        LIMIT 3

        // ORDER BY
        MATCH (node:LABEL_1)
        WHERE node.attribute >= X
        RETURN node
        // Would skip the first node
        SKIP 1
        ORDER BY node.attribute_1 DESC
        LIMIT 3        

3. Read by Node-Node Relationship

        MATCH (node_1:LABEL_1) -[rel:RELATIONSHIP_1]-> (node_2:LABEL_2)
        WHERE node_1.attribute_1 = "X" AND node_2.attribute_1 ="Y"
        RETURN node_1, node_2.attribute_1

4. Read by Node-Relationship attributes

        MATCH (node_1:LABEL_1) -[rel:RELATIONSHIP_1]-> (node_2:LABEL_2)
        WHERE node_1.attribute = "X" AND rel.attribute_1 >= "Y"
        RETURN node_1

5. Aggregate

        MATCH (node_1:LABEL_1) -[rel:RELATIONSHIP_1]- (node_2:LABEL_2)
        RETURN node_1.attribute_1, COUNT(rel), AVG(rel.attribute_1) as RESULT
        ORDER BY RESULT ASC

### UPDATE

1. Updating value

        MATCH (node:LABEL_1)
        WHERE node.attribute_1 = "X"
        SET node.attribute_2 = "Y", node.attribute_3 = "Z"
        RETURN node

2. Removing value

        MATCH (node:LABEL_1)
        WHERE node.attribute_1 = "X"
        REMOVE node.attribute_3
        RETURN node

### DELETE

1. Deleting node and relationship

        MATCH (node:LABEL_1)
        WHERE node.attribute_1 = "X"
        DETACH DELETE node

2. Deleting relationship

        MATCH (node_1:LABEL_1) -[rel:RELATIONSHIP_1]-> (node_2: LABEL_2)
        DELETE rel

### Legends

    RELATIONSHIP_1: Bi-directional
    RELATIONSHIP_2: Uni-directional
    RELATIONSHIP_3: Uni-directional with attributes

## Spring

### Dependencies

    // Gradle
    implementation("org.springframework.boot:spring-boot-starter-data-neo4j")
    implementation("org.neo4j.driver:neo4j-java-driver")

### Endpoints

1. Create `/course/add`
    - Post Mapping

            {
                "identifier": "CS101",
                "title": "C++",
                "teacher": "John Doe"
            }

2. Read `/course/{id}`, to get all `/courses/all`
    - Get Mapping

3. Update `/course/update/{id}`
    - Put Mapping

4. Delete `/course/delete/{id}`
    - Delete Mapping

## Learning Resources:

### Neo4j (Graph Database) Crash Course 

- [YouTube](https://www.youtube.com/watch?v=8jNPelugC2s) 
- [GitHub](https://github.com/harblaith7/Neo4j-Crash-Course/tree/main)

### Neo4j Course for Beginners

- [YouTube](https://www.youtube.com/watch?v=_IgbB24scLI)
- [GitHub](https://github.com/fhsinchy/spring-neo4j)