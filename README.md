# MiraiConfigHelper
****

## 介绍
**MiraiConfigHelper 是一个便利于Java的本地config配置文件生成插件。插件的代码简单，只是利用了[Jackson](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)来生成本地Json配置文件。想要了解并自己开发优化可以浏览[JacksonDoc](https://www.tutorialspoint.com/jackson/index.htm)**

**[插件](https://github.com/Raptor-wxw/MiariConfigHelper/releases)可以供给小白，或者使用Java来进行Mirai编程的开发者使用的开发者。插件提供三个方法（我觉得目前完全够用），如果有用户使用本插件且觉得有待丰富，可以提交[issue](https://github.com/Raptor-wxw/MiariConfigHelper/issues)。</br>**

## 功能
**插件功能包括：**
- **createConfigFile()** &emsp;&emsp;&emsp;_创建本地配置文件_
- **setConfigFile()** &ensp;&emsp;&emsp;&emsp;&emsp;_将配置类写入到本地配置文件_
- **getConfigFromFile()** &emsp;&emsp;_从本地文件加载配置项到内存_

&emsp;
### createConfigFile()
**传参个数：1** \
**传参类型：String** \
**传参意义：传入参数为本地配置项文件名（不加后缀）** \
例：

```java
try {
    JavaConfigHelper.createConfigFile("Config");
} catch (IOException e) {
    throw new RuntimeException(e);
}
```

**这会在Mirai安装目录下的config目录下新建Config文件夹，并在Config文件夹内生成Config.json文件。**


### setConfigFile()
**传参个数：2** \
**参数1类型：String** \
**参数1意义：传入参数为本地配置项文件名（不加后缀）** \
**参数2类型：Object** \
**参数2意义：传入参数为工程项目中配置类的对象** \
例：

```java
JavaConfigHelper.setConfigFile("Config", Config.INSTANCE);
```

**这会将项目中Config类在内存中的数据保存到Config/Config.json配置文件中。**


### getConfigFromFile()

**传参个数：2** \
**参数1类型：String** \
**参数1意义：传入参数为本地配置项文件名（不加后缀）** \
**参数2类型：Class** \
**参数2意义：传入参数为工程项目中配置类的类对象** \
例：

```java
JavaConfigHelper.getConfigFromFile("User", User.class);
```

**这会将本地配置文件Config.json文件中的配置项加载到项目中Config类的内存中。**

## 使用方式

**下载[Release](https://github.com/Raptor-wxw/MiariConfigHelper/releases)中的jar包[MiraiConfigHelper.main.jar](https://github.com/Raptor-wxw/MiariConfigHelper/releases/download/v1.0.0/MiraiConfigHelper.main.jar)，将他导入到工程项目的Libraries中即可使用。工具类的类名为JavaConfigHelper，IDEA用户可以使用Alt+Enter自动导入import。或者手动输入*import cn.hive_net.JavaConfigHelper;***

#### 导入jar包操作示例（IDEA）

**1.在项目中新建lib文件夹，并将下载的jar包放入文件夹中。**

![1.png](https://s2.loli.net/2022/05/12/RWqFPHsE4JIn5av.png)

**2.依次打开File -> Project Structure -> 点击+加号 -> 选择Java。**

![2.png](https://s2.loli.net/2022/05/12/4J6DjIoYkqGtvBV.png)

**3.在弹出的窗口中选择lib文件夹中的MiraiConfigHelper.main.jar，并点击确定，一路确定。**

![3.png](https://s2.loli.net/2022/05/12/8mGgeEzSAjv751F.png)

**4.然后就可以开始代码的开发了，示例代码如下：**

**User.java**

```java
public class User {

    public static final User INSTANCE = new User();
    String name;
    int age;

    private User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

**JavaConfigTest.java**

```java
import cn.hive_net.JavaConfigHelper;

import java.io.IOException;

public class JavaConfigTest {

    public static void main(String[] args) throws IOException {

        // 创建本地配置文件
        try {
            JavaConfigHelper.createConfigFile("User");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 设置User的值
        User.INSTANCE.setName("王晓文");
        User.INSTANCE.setAge(21);

        // 将配置类写入到本地配置文件
        JavaConfigHelper.setConfigFile("User", User.INSTANCE);

        // 从本地文件加载配置项到内存
        JavaConfigHelper.getConfigFromFile("User", User.class);

        // 获取User的值
        System.out.println(User.INSTANCE.getName());
        System.out.println(User.INSTANCE.getAge());
    }
}
```

