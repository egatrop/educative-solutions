dependencies {
    // Other dependencies.
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}