[![Build](https://github.com/ShanePark/psh/actions/workflows/gradle.yml/badge.svg)](https://github.com/ShanePark/psh/actions/workflows/gradle.yml)
[![Codecov branch](https://img.shields.io/codecov/c/github/shanepark/psh/master)](https://app.codecov.io/gh/ShanePark/psh)
# PSH
> Problem Solving Helper

This helps you to solve problems on LeetCode, HackerRank, etc.  
It doesn't suggest you any solution, but it helps you to make test cases and check the result easily.

## Preview

![img](images/preview.png)

## LeetCode

Making testcases for TreeNode and ListNode on Leetcode is a bit annoying.
If you use PSHelper, you can make testcases really simply.

**TreeNode**

```java
@Test
public void of(){
    TreeNode root=TreeNode.of(1,null,2,3,4,null,null,5,6);
    assertThat(root.val).isEqualTo(1);
    assertThat(root.left).isNull();
    assertThat(root.right.val).isEqualTo(2);
    assertThat(root.right.left.val).isEqualTo(3);
    assertThat(root.right.right.val).isEqualTo(4);
    assertThat(root.right.right.left.val).isEqualTo(5);
    assertThat(root.right.right.right.val).isEqualTo(6);
}

@Test
public void of2(){
    TreeNode root=TreeNode.of(1,null,2,null,3,null,4,null,5);
    assertThat(root.val).isEqualTo(1);
    assertThat(root.left).isNull();
    assertThat(root.right.val).isEqualTo(2);
    assertThat(root.right.left).isNull();
    assertThat(root.right.right.val).isEqualTo(3);
    assertThat(root.right.right.left).isNull();
    assertThat(root.right.right.right.val).isEqualTo(4);
    assertThat(root.right.right.right.left).isNull();
    assertThat(root.right.right.right.right.val).isEqualTo(5);
}
```

**ListNode**

```java
@Test
public void testToString(){
    String str=ListNode.of(1,2,3,4,5).toString();
    System.out.println("str = "+str);
}
// str = ListNode{val=1, next=ListNode{val=2, next=ListNode{val=3, next=ListNode{val=4, next=ListNode{val=5, next=null}}}}}
```

## Intallation

### Gradle

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
dependencies {
    ...
    implementation 'com.github.shanepark:psh:master-SNAPSHOT'
}
```

### Maven

```xml
<project>
  <repositories>
    <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
    </repository>
  </repositories>

  <dependencies>
    <dependency>
      <groupId>com.github.shanepark</groupId>
      <artifactId>psh</artifactId>
      <version>master-SNAPSHOT</version>
    </dependency>
  </dependencies>
</project>
```
