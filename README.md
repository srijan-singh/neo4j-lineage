# Neo4j-Basics

## Commands

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
