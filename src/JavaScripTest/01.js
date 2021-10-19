/*
JS变量：
    数值类型：number
    函数类型：function
    undefined：所有JS变量的初始值
    NAN：not a number
 */
//创建变量let
alert("你好")
let name = "li";
//创建关键字const，
const guesses = document.querySelector('.guesses');

// alert(typeof(guesses));
// alert(guesses)

//逻辑运算，0，null，undefined，空字符串为false，其余为true
//a&&b（断路） 返回最后一个表达式的值，如果途中有假，返回为假的表达式
//a||b（断路） 途中有真，返回真的表达式

//数组,赋值时会自动扩容,类型可以不一致
let nums = [1, 2, 3];
nums[5]="abc"
for (let i = 0; i < nums.length; i++) {
    // alert(nums[i]);
}

//函数定义,不允许重载即相应的函数名只能有一个函数
function f1(a,b){
    alert("函数1"+a+b);
}

// f1(1,"123");
//定义带返回值的函数，方式：直接return
function f2(){
    let sum=0;
    for (let i = 0; i < arguments.length; i++) {
        if(typeof (arguments[i])=="number"){
            sum += arguments[i];
        }
        return sum;
    }
}

//函数第二种定义方式
let sum=function (a,b){
    return a+b;
}
// sum(1, 2);

//自定义对象
let obj = new Object();
obj.name = "li";
obj.f3=function (){
    alert(obj.name);
}

//自定义对象2
let obj2={
    name: "li",
    age: 17,
    f3:function (){
        alert(obj2.age);
    }
}
//js中事件
/*
onload 加载完成事件：页面加载后，常用于做页面js代码初始化操作
onclick单击事件：
onblur失去焦点事件
onchange内容发生改变事件
onsubmit表单提交事件
事件的注册（告诉游览器当事件响应后要执行哪些操作代码）分为静态注册和动态注册
静态注册(只读到了HTML对应的行数)：通过HTML标签的事件属性直接赋予事件响应后的代码
动态注册(页面读完了)：通过js代码得到标签的dom对象，然后通过dom对象.事件名=function（）{}这种形式赋予事件响应后的代码

 */
//固定写法
window.onload=function () {
    // 动态注册的基本步骤：1.获取标签对象,document表示js提供的一个对象（整个文档）
    let button1=document.getElementById("button1");
//     2.通过dom对象.事件名=function（）{}这种形式赋予事件响应后的代码
    button1.onclick=function () {
        alert(Date.now().toExponential());
    }
    let blur1=document.getElementById("blur1");
    blur1.onblur=function () {
        //控制台输出
        console.log("动态注册失去焦点");
    }
    let onchange1 = document.getElementById("兴趣");
    onchange1.onchange=function () {
        alert("兴趣变了");
    }
    let submit = document.getElementById("表单");
    submit.onsubmit=function () {
        alert("注册不合法，无法提交");
        return false;
    }
}

//DOM模型：document object model，html是以document文档树的结构形式进行存储的,tagName：标签名(input,button)
//test()测试字符串是否匹配我的规则(正则表达式)
/*正则表达式
[abc]:包含a,b,c任何字符
[^abc]:都不包含
[0-9],[A-Z]...
\w:查找单词字符（数字，字母，下划线）
\W:非单词
\d:数字
\s:空白字符
\b:匹配单词边界
\0:null
a+:至少一个
a*:>=0
a?:0|1
a{x}:连续的x个
a{x,y}:连续的x-y个
a?:a结尾
^a:a开头
 */
let patt=/^\w{5,12}$/;
function onclickFun(){
    let user = document.getElementById("username");
    let userSpan = document.getElementById("userSpan");
    let button = document.getElementById("check");
        //innerHTML表示起始标签和结束标签之间的内容
    if (!patt.test(user.value)) {
        userSpan.innerHTML = "用户名格式错误";
    }else{
        userSpan.style = "color: #06ff36";
        userSpan.innerHTML = "通过";
    }
}
// document.getElementsByName();//返回集合
function selectAll(){
    let select = document.getElementsByName("hobby");
    for (let i = 0; i < select.length; i++) {
        select[i].checked=true;
    }
}
function selectNo(){
    let select = document.getElementsByName("hobby");
    for (let i = 0; i < select.length; i++) {
        select[i].checked=false;
    }
}
function selectReverse(){
    let select = document.getElementsByName("hobby");
    for (let i = 0; i < select.length; i++) {
        select[i].checked=!select[i].checked;
    }
}

//dom属性
/*
childNotes:当前节点的所有子节点
firstChild：当前节点的第一个子节点
lastChild:
parentNode
nextSibling：当前节点的下一个节点
previousSibling
className：用于获取或设置标签的class属性
innerHTML
innerText：起始标签和结束标签中的文本
 */

// document.createElement(),新建一个标签
window.onload=function (){
    let divobj=document.createElement("div");
    divobj.innerHTML = "新建标签";
    //添加子元素
    document.body.appendChild(divobj);

}

