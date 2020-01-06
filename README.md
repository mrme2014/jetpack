# Jetpack全组件源码分析,用法改造(网络上搜索不到的高级用法)

#### 为什么要学习Jetpack
- Jetpack是Google为解决Android开发碎片化，打造成熟健康生态圈提出的战略规划，是Google对Android未来提出的发展方向。

- Jetpack现已成为面试必问,各大厂+github都已经在拥抱适配Jetpack了。

- 谷歌力推一统开发规范,support库停更
所以我认为只要是安卓开发的同学，都或者或晚的要拥抱Jetpack。

#### Jetpack核心组件介绍
- Navigation:强大的APP导航组件,能够为Activity,Fragment,Dialog,FloatWindow提供导航。
- Paging:强大的分页库组件,能够自动化加载页面初始化和分页(向前分页,向后分页)数据。
- LiveData:基于生命周期的消息订阅组件,不会发生内存泄漏，不用反注册。
- Room:灵活易用的数据库组件，对sqlite做了上层包装，无缝对接LiveData。
- ViewModel:数据共享组件,能够实现数据的存储和页面间数据共享。
- CameraX:强大的基于生命周期的相机控制组件。轻松定制视频录制&拍照功能。
- DataBinding:空安全的数据与View双向绑定组件，减少异常率
- WorkManager:强大的后台任务,异步任务管理组件
- Lifecycles:生命周期管理组件
Jetpack包含了非常多的优秀的组件,但是目前国内关于Jetpack的文章质量良莠不齐,或者说直接翻译英文的比较多,难以引用到项目中。更别谈改造灵活应用了。

#### 目前的痛点
包括但不限于以下问题,目前都在网络上都难以搜索到优秀的解决方案。本人经历了4个月的时间，潜心研究Jetpack,基于本人的理解，使用Jetpack全家桶组件开发了一套前后端打通的高仿短视频应用的APP--皮皮虾。旨在帮助大家在短时间内高效的掌握Jetpack的工作原理和一些搜索不到的用法。
- PagedList如何实现列表增删改？
- Paging分页失败后，如果接管列表分页？
- Paging如何解决先添加HeaderView,后展示网络数据，列表定位错乱的问题？
- Paging如何先展示缓存数据，在展示网络数据？
- 如何改造Navigation，实现自动化构建App路由导航？
- LiveData如何设计一款0反射的事件总线？
- Navigation如何自动化构建App 路由导航
- Behavior如何接管CoordinatorLayout中组件的布局？
- Room数据库如何设计一套缓存框架？
- ViewModel如何实现数据共享？
- 列表视频秒播，跨页视频无缝续播？
- 如何实现页面按需预加载？


# [立即拥抱Jetpack](https://www.jianshu.com/u/b742453da80a)
