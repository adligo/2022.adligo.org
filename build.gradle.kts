import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * This is a new fangled way to build Java using Kotlin :)
 * 
 * @author scott
 *         <pre>
 *         <code>
 * ---------------- Apache ICENSE-2.0 --------------------------
 *
 * Copyright 2022 Adligo Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </code>
 * 
 *         <pre>
 */
fun allPlugins(p: Project) {
  p.apply(plugin="java")
  p.apply(plugin="eclipse")
}

fun allRepos(r: RepositoryHandler) {
  r.mavenLocal()
  r.mavenCentral()
}

plugins {
  println("plugins is ")
  println(this)
  //allPlugins(this);
  eclipse
  java
}

dependencies {
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(11))
  }
}

fun dependsOnCtx(dhs: DependencyHandlerScope) {
   dependsOnICtx4Jse(dhs)
   dependsOnIThreads(dhs)
   dhs.implementation(project("ctx.adligo.org"))
}

fun dependsOnCtx4Jse(dhs: DependencyHandlerScope) {
   dependsOnCtx(dhs)
   dhs.implementation(project("ctx4jse.adligo.org"))
}

fun dependsOnICtx(dhs: DependencyHandlerScope) {
   dhs.implementation(project("i_ctx.adligo.org"))
}

fun dependsOnICtx4Jse(dhs: DependencyHandlerScope) {
   dependsOnICtx(dhs)
   dhs.implementation(project("i_ctx4jse.adligo.org"))
}

fun dependsOnIPipe(dhs: DependencyHandlerScope) {
   dhs.implementation(project("i_pipe.adligo.org"))
}

fun dependsOnIThreads(dhs: DependencyHandlerScope) {
   dhs.implementation(project("i_threads.adligo.org"))
}

fun dependsOnITests4j(dhs: DependencyHandlerScope) {
   dhs.implementation(project("i_tests4j.adligo.org"))
}

fun dependsOnJaxb(dhs: DependencyHandlerScope) {
  dhs.implementation("javax.xml.bind:jaxb-api:2.4.0-b180830.0359") 
}

fun dependsOnTests4j4jj(dhs: DependencyHandlerScope) {
  dependsOnITests4j(dhs)
  dependsOnJUnit5(dhs)
  dependsOnMockitoExt(dhs)
  dhs.implementation(project("tests4j4jj.adligo.org"))
}

fun dependsOnJUnit5(dhs: DependencyHandlerScope) {
  dhs.implementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
  dhs.implementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

fun dependsOnMockito(dhs: DependencyHandlerScope) {
   dhs.implementation("org.mockito:mockito-all:1.10.19")
}

fun dependsOnMockitoExt(dhs: DependencyHandlerScope) {
   dependsOnMockito(dhs)
   dhs.implementation(project(":mockito_ext.adligo.org"))
}

fun dependsOnPipe(dhs: DependencyHandlerScope) {
   dependsOnIPipe(dhs)
   dhs.implementation(project("pipe.adligo.org"))
}

fun dependsOnTests4j(dhs: DependencyHandlerScope) {
  dependsOnITests4j(dhs)
  dependsOnJaxb(dhs)
  dhs.implementation(project("tests4j.adligo.org"))
}

project(":ctx.adligo.org") {
  allPlugins(this)
  dependencies {
    dependsOnICtx4Jse(this)
    dependsOnIThreads(this)
  }
  repositories {
    allRepos(this)
  }
}

project(":ctx_tests.adligo.org") {
  allPlugins(this)
  dependencies {
    dependsOnCtx(this)
    dependsOnTests4j4jj(this)
  }
  repositories {
    allRepos(this)
  }
}

project(":gwt_ctx_example.adligo.org") {
  allPlugins(this)
  dependencies {
    dependsOnCtx(this)
    implementation("com.google.gwt:gwt-user:2.9.0")
    implementation("com.google.gwt:gwt-dev:2.9.0")
  }
  repositories {
    allRepos(this)
  }
}

project(":i_ctx.adligo.org") {
  allPlugins(this)
  repositories {
    allRepos(this)
  }
}

project(":i_ctx4jse.adligo.org") {
  allPlugins(this)
  dependencies {
    dependsOnICtx(this)
  }
  repositories {
    allRepos(this)
  }
}

project(":i_ctx4jse.adligo.org") {
  allPlugins(this)
  repositories {
    allRepos(this)
  }
}

project(":i_pipe.adligo.org") {
  allPlugins(this)
  repositories {
    allRepos(this)
  }
}

project(":i_tests4j.adligo.org") {
  allPlugins(this)
  repositories {
    allRepos(this)
  }
}

project(":i_threads.adligo.org") {
  allPlugins(this)
  repositories {
    allRepos(this)
  }
}

project(":i_threads4jse.adligo.org") {
  allPlugins(this)
  dependencies {
    dependsOnIThreads(this)
  }
  repositories {
    allRepos(this)
  }
}
project(":mockito_ext.adligo.org") {
  allPlugins(this)
  dependencies {
    dependsOnMockito(this)
  }
  repositories {
    allRepos(this)
  }
}

project(":pipe.adligo.org") {
  allPlugins(this)
  dependencies {
    dependsOnIPipe(this)
  }
  repositories {
    allRepos(this)
  }
}

project(":pipe_tests.adligo.org") {
  allPlugins(this)
  dependencies {
    dependsOnPipe(this)
  }
  repositories {
    allRepos(this)
  }
}

project(":tests4j.adligo.org") {
  allPlugins(this)
  dependencies {
    dependsOnITests4j(this)
    dependsOnJaxb(this)
  }
  repositories {
    allRepos(this)
  }
}

project(":tests4j4jj.adligo.org") {
  allPlugins(this)
  dependencies {
    dependsOnITests4j(this)
    dependsOnJUnit5(this)
    dependsOnMockitoExt(this)
  }
  repositories {
    allRepos(this)
  }
}

project(":tests4j4jj_tests.adligo.org") {
  allPlugins(this)
  dependencies {
    dependsOnTests4j4jj(this)
  }
  repositories {
    allRepos(this)
  }
}

project(":tests4j_4mockito.adligo.org") {
  allPlugins(this)
  dependencies {
    dependsOnTests4j(this) 
    //an old version of Mockito that uses jdk 1.5 byte code for Apache Beam
    implementation("org.mockito:mockito-all:1.10.19")
    implementation(project(":tests4j.adligo.org"))
  }
  repositories {
    allRepos(this)
  }
}
repositories {
  mavenLocal()
  mavenCentral()
}

/**
I have found that the JAVA_HOME environment variable that is set when your run this task ;
    gradle cleanEclipse eclipse
is the one that is included in the Eclipse BuildPath
*/
tasks.register<GradleBuild>("ecp") {
    tasks = listOf("cleanEclipseClasspath", "eclipseClasspath")
}




