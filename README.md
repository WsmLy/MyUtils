# MyUtils
建立一个仓库存储自己常用的一些工具
目前正在添加，欢迎广大码农朋友们进行优化指导，谢谢！
ContextUtils:
    getContext(): 获取当前全局Context
    setContext(Context context): 设置全局Context，最好是在Application中设置。
DisplayUtils:
    px2dp(): 将px转换成dp
    dp2px(): 将dp转换成px
    px2sp(): 将px转换成sp
    sp2px(): 将sp转换成px
    dp2sp(): 将dp转换成sp
    sp2dp(): 将sp转换成dp
    getScreenSize(): 获取屏幕大小，返回包含屏幕宽高的screenInfo
    getStatusBarHeight(): 获取状态栏高度
ToastUtils:
    showToastForLong(): 较长时间的toast
    showToastForShort(): 较短时间的toast
