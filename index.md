#Git
>分布式版本控制工具，可以快速的处理从小型到大型的各种项目，Git具有廉价的本地库，
> 方便的暂存区域和多个工作流分支等特性
- **版本控制**：记录文件内容变化，可以记录文件修改记录,可以从个人开发过渡到团队协作
- **版本控制工具**
    - 集中式：有一个单一的集中管理的服务器，保存所有文件的修订版本，缺点：中央服务器故障，所有人都无法提交更新
    - 分布式：clone远程库，在本地库进行版本控制
- **工作机制**：
    - 工作区：存放代码的磁盘位置
    - 暂存区：把工作区的代码临时存储到（git add）暂存区，可删除（git rm --cached hello.txt）
    - 本地库：把暂存区的代码提交到（ git commit -m "first commit" hello.txt）本地库，生成历史版本。
    - 远程库：把本地库代码推送到（push）远程库（GitLab（局域网），GitHub，Gitee码云）
- **设置用户名**：作用是区分是哪个用户提交的代码，和GitHub账号无关
    - git config --global user.name 用户名
    - cat 文件：查看文件
- **初始化本地库**：cd到磁盘路径(/d/gitSpace)，git init
- **查看当前目录下的文件**：ll -a，-a用来查看隐藏文件
- **查看本地库状态**：git status，可查看本地库和暂存区
- **粘贴复制保存**：p粘贴,yy复制，wq保存
- **查看本地库文件树**：git reflog
- **查看本地库日志**：git log
- **版本切换**：git reset --hard 99b9f68，相当于头指针指向当前版本号
- **根据远程库更新本地库**： git pull 分支（只更新修改的部分）
- **添加文件夹**：git add 文件夹/.

###Git分支操作
> 实质是多创建一个指针
- **创建分支**：git branch 分支名
- **查看分支**：git branch -v
- **切换分支**：git checkout 分支名
- **把指定分支合并到当前分支上**：git merge 分支名
- **分支冲突**：两分支修改了同一个文件，两分支合并时会产生冲突

#GitHub远程库
- **Git创建别名**：给远程库网址创建别名， git remote add zxd.github.io https://github.com/1364354238/zxd.github.io
- **本地库推送给远程库**：git push 别名 分支（远程库没有该分支会创建，有会更新）
- **克隆远程库**：git clone https://github.com/1364354238/zxd.github.io ，本质上的操作是
1.拉取远程库（pull），2.初始化本地库，3.创建别名
 **插入别人的项目**：登录自己账户，登录项目网址，fork
  
#IDEA配置
> 忽略不必要的文件
- 创建.ignore文件
- vcs:create git repository
- 加入到暂存区，右键-》git-》add
- 提交本地库，git-》commit
- push到远程库：SSH keys（要保证本地库代码版本要比远程库的版本要高，push前先pull）

#Gitee码云

#GitLab