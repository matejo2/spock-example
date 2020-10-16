# spock-example
a super simple spock implementation with spring framework

For using spock you have to add two dependencies, spock-core and spock-spring (if you are using it in the spring context)

```xml
<dependency>
	<groupId>org.spockframework</groupId>
	<artifactId>spock-core</artifactId>
	<version>1.3-groovy-2.5</version>
</dependency>
<dependency>
	<groupId>org.spockframework</groupId>
	<artifactId>spock-spring</artifactId>
	<version>1.3-groovy-2.5</version>
</dependency>
```

and for using groovy you need to add the gmaven plus plugin

```xml
<plugin>
<groupId>org.codehaus.gmavenplus</groupId>
<artifactId>gmavenplus-plugin</artifactId>
<version>1.9.0</version>
<executions>
	<execution>
		<goals>
			<goal>compile</goal>
			<goal>compileTests</goal>
		</goals>
	</execution>
</executions>
</plugin>
```

