# git使用

## git界面化操作工具TortoiseGit

下载地址：https://download.tortoisegit.org/tgit/2.8.0.0/

安装成功后，右击就会出现相关TortoiseGit的操作

- 克隆项目
- 同步代码：右击，同步，拉取。
- 提交代码：先将修改的代码提交某个分支，如master；书写注释，然后提交

![](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1572794229215.png)

- 然后进行同步：这里为推送，即将代码提交到远程仓库

![1572794695894](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1572794695894.png)

- 远程仓库代码获得更新

![1572794769013](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1572794769013.png)



- ###### 解决代码冲突

- 克隆两份代码

![1572794885838](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1572794885838.png)

- 修改两份代码的同一个文件

![1572795079804](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1572795079804.png)

- 提交01 test文件，并且推送到远端仓库

![1572795135526](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1572795135526.png)

![1572795179740](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1572795179740.png)

- 确认远端仓库代码更新

![1572795213646](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1572795213646.png)

- 在不获取最新代码时，source02代码提交

![1572795266712](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1572795266712.png)

- 推送至远端

![1572795302689](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1572795302689.png)

- 会发现提交失败，所以要先拉取最新代码

![1572795469870](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1572795469870.png)

- 获取到的冲突

![1572795513554](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1572795513554.png)

- 合并两个冲突，选中两行，优先使用其中之一

![1572796018070](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1572796018070.png)

- 解决冲突后提交到远程仓库，查看仓库代码

![1572796202402](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1572796202402.png)

