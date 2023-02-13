# shaneutils
this repository is for util modules i frequently use

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
  implementation 'com.github.Shane-Park:shaneutils:master-SNAPSHOT'
}
```
### Maven
```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
  
<dependency>
  <groupId>com.github.Shane-Park</groupId>
  <artifactId>shaneutils</artifactId>
  <version>master-SNAPSHOT</version>
</dependency>
```

## Preview
![img](shaneutils.png)

### LeetCode
**TreeNode**
```java
@Test
public void of() {
    TreeNode root = TreeNode.of(1, null, 2, 3, 4, null, null, 5, 6);
    assertThat(root.val).isEqualTo(1);
    assertThat(root.left).isNull();
    assertThat(root.right.val).isEqualTo(2);
    assertThat(root.right.left.val).isEqualTo(3);
    assertThat(root.right.right.val).isEqualTo(4);
    assertThat(root.right.right.left.val).isEqualTo(5);
    assertThat(root.right.right.right.val).isEqualTo(6);
}

@Test
public void of2() {
    TreeNode root = TreeNode.of(1, null, 2, null, 3, null, 4, null, 5);
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
public void testToString() {
    String str = ListNode.of(1, 2, 3, 4, 5).toString();
    System.out.println("str = " + str);
}
```
str = ListNode{val=1, next=ListNode{val=2, next=ListNode{val=3, next=ListNode{val=4, next=ListNode{val=5, next=null}}}}}
