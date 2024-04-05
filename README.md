# Neo4j-Basics

## Commands

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

        // Equals
        MATCH (node:LABEL_1)
        WHERE node.attribute_1 = "X"
        RETURN node
    
        // Not Equal
        MATCH (node:LABEL_1)
        WHERE node.attribute_1 <> "X"
        RETURN node

        // Greater than or less than
        MATCH (node:LABEL_1)
        WHERE node.attribute_1 >= 0 AND node.attribute_1 <=10
        RETURN node

        // LOGIC OPERATION NOT
        MATCH (node:LABEL_1)
        WHERE NOT node.attribute_1 = "X"
        RETURN node

        // LOGIC OPERATION AND
        MATCH (node:LABEL_1)
        WHERE node.attribute_1 = "X" AND node.attribute_2 = "Y"
        RETURN node

        // LOGIC OPERATION OR
        MATCH (node:LABEL_1)
        WHERE node.attribute_1 = "X" OR node.attribute_2 = "Y"
        RETURN node

3. Read by Node-Node Relationship

        MATCH (node_1:LABEL_1) -[rel:RELATIONSHIP_1]-> (node_2:LABEL_2)
        WHERE node_1.attribute_1 = "X" AND node_2.attribute_1 ="Y"
        RETURN node_1, node_2.attribute_1

4. Read by Node-Relationship attributes

        MATCH (node_1:LABEL_1) -[rel:RELATIONSHIP_1]-> (node_2:LABEL_2)
        WHERE node_1.attribute = "X" AND rel.attribute_1 >= "Y"
        RETURN node_1


### Legends

    RELATIONSHIP_1: Bi-directional
    RELATIONSHIP_2: Uni-directional
    RELATIONSHIP_3: Uni-directional with attributes

#### Example Query

    CREATE

    (dev1:Employee {name: "Adam", role: "Frontend Developer"}),
    (dev2:Employee {name: "Eve", role: "Backend Developer"}),

    (manager:Manager {name: "John Doe", department: "Engineering"}),

    (company:Company {name: "Acme Corp"}),

    (dev1)-[:WORKS_WITH]->(dev2),
    (dev1)<-[:WORKS_WITH]-(dev2),

    (manager)-[:MANAGES]->(dev1),
    (manager)-[:MANAGES]->(dev2),

    (dev1)-[:EMPLOYED_BY {start_date: "2022-01-01", salary: 80000}]->(company),
    (dev2)-[:EMPLOYED_BY {start_date: "2022-01-01", salary: 85000}]->(company),
    (manager)-[:EMPLOYED_BY {start_date: "2020-05-15", salary: 120000}]->(company);


## Spring
