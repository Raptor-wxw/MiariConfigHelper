# MiraiConfigHelper
****

## ����
**MiraiConfigHelper ��һ��������Java�ı���config�����ļ����ɲ��������Ĵ���򵥣�ֻ��������[Jackson](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)�����ɱ���Json�����ļ�����Ҫ�˽Ⲣ�Լ������Ż��������[JacksonDoc](https://www.tutorialspoint.com/jackson/index.htm)**

**[���](https://github.com/Raptor-wxw/MiariConfigHelper/releases)���Թ���С�ף�����ʹ��Java������Mirai��̵Ŀ�����ʹ�õĿ����ߡ�����ṩ�����������Ҿ���Ŀǰ��ȫ���ã���������û�ʹ�ñ�����Ҿ����д��ḻ�������ύ[issue](https://github.com/Raptor-wxw/MiariConfigHelper/issues)��</br>**

## ����
**������ܰ�����**
- **createConfigFile()** &emsp;&emsp;&emsp;_�������������ļ�_
- **setConfigFile()** &ensp;&emsp;&emsp;&emsp;&emsp;_��������д�뵽���������ļ�_
- **getConfigFromFile()** &emsp;&emsp;_�ӱ����ļ�����������ڴ�_

&emsp;
### createConfigFile()
**���θ�����1** \
**�������ͣ�String** \
**�������壺�������Ϊ�����������ļ��������Ӻ�׺��** \
����

```java
try {
    JavaConfigHelper.createConfigFile("Config");
} catch (IOException e) {
    throw new RuntimeException(e);
}
```

**�����Mirai��װĿ¼�µ�configĿ¼���½�Config�ļ��У�����Config�ļ���������Config.json�ļ���**


### setConfigFile()
**���θ�����2** \
**����1���ͣ�String** \
**����1���壺�������Ϊ�����������ļ��������Ӻ�׺��** \
**����2���ͣ�Object** \
**����2���壺�������Ϊ������Ŀ��������Ķ���** \
����

```java
JavaConfigHelper.setConfigFile("Config", Config.INSTANCE);
```

**��Ὣ��Ŀ��Config�����ڴ��е����ݱ��浽Config/Config.json�����ļ��С�**


### getConfigFromFile()

**���θ�����2** \
**����1���ͣ�String** \
**����1���壺�������Ϊ�����������ļ��������Ӻ�׺��** \
**����2���ͣ�Class** \
**����2���壺�������Ϊ������Ŀ��������������** \
����

```java
JavaConfigHelper.getConfigFromFile("User", User.class);
```

**��Ὣ���������ļ�Config.json�ļ��е���������ص���Ŀ��Config����ڴ��С�**

## ʹ�÷�ʽ

**����[Release](https://github.com/Raptor-wxw/MiariConfigHelper/releases)�е�jar��[MiraiConfigHelper.main.jar](https://github.com/Raptor-wxw/MiariConfigHelper/releases/download/v1.0.0/MiraiConfigHelper.main.jar)���������뵽������Ŀ��Libraries�м���ʹ�á������������ΪJavaConfigHelper��IDEA�û�����ʹ��Alt+Enter�Զ�����import�������ֶ�����*import cn.hive_net.JavaConfigHelper;***

#### ����jar������ʾ����IDEA��

**1.����Ŀ���½�lib�ļ��У��������ص�jar�������ļ����С�**

![1.png](https://s2.loli.net/2022/05/12/RWqFPHsE4JIn5av.png)

**2.���δ�File -> Project Structure -> ���+�Ӻ� -> ѡ��Java��**

![2.png](https://s2.loli.net/2022/05/12/4J6DjIoYkqGtvBV.png)

**3.�ڵ����Ĵ�����ѡ��lib�ļ����е�MiraiConfigHelper.main.jar�������ȷ����һ·ȷ����**

![3.png](https://s2.loli.net/2022/05/12/8mGgeEzSAjv751F.png)

**4.Ȼ��Ϳ��Կ�ʼ����Ŀ����ˣ�ʾ���������£�**

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

        // �������������ļ�
        try {
            JavaConfigHelper.createConfigFile("User");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // ����User��ֵ
        User.INSTANCE.setName("������");
        User.INSTANCE.setAge(21);

        // ��������д�뵽���������ļ�
        JavaConfigHelper.setConfigFile("User", User.INSTANCE);

        // �ӱ����ļ�����������ڴ�
        JavaConfigHelper.getConfigFromFile("User", User.class);

        // ��ȡUser��ֵ
        System.out.println(User.INSTANCE.getName());
        System.out.println(User.INSTANCE.getAge());
    }
}
```

