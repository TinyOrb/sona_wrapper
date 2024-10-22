## Default plugins


### Plugin for compile: `maven-compiler-plugin`

Sample plugins setup with java compiler direct with path and build phase with goal compile
```
<build>
        <sourceDirectory>${PROJECT_HOME}/src/main</sourceDirectory>
        <testSourceDirectory>${PROJECT_HOME}/src/test</testSourceDirectory>
    [...]
    <plugins>
        [...]
        <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.13.0</version>
                <configuration>
                    <release>11</release>
                    <fork>true</fork>
                    <executable>${JAVA_HOME}/bin/javac</executable>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>compile</goal>
                        </goals>
                        <configuration>
                            <includes>
                                <include>src/main/.../*.java</include>
                            </includes>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
            [...]
        </plugins>
    [...]
</build>
```

For execultion 
```
mvn compile
```