#/bin/sh
# Test with H2
mvn test -Pderby
mvn test -Ph2
mvn test -Phsqldb
