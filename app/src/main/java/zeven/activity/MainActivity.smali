.class public Lzeven/test/activity/MainActivity;
.super Landroid/app/Activity;
.source "MainActivity.java"


# instance fields
.field dataList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lzeven/unique/vo/MainItemViewVO;",
            ">;"
        }
    .end annotation
.end field

.field mainList:Landroid/widget/ListView;
    .annotation build Lbutterknife/Bind;
        value = {
            0x7f0a000f
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 23
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lzeven/test/activity/MainActivity;->dataList:Ljava/util/ArrayList;

    return-void
.end method

.method private init()V
    .registers 4

    .prologue
    .line 48
    new-instance v1, Lzeven/unique/vo/MainItemViewVO;

    invoke-direct {v1}, Lzeven/unique/vo/MainItemViewVO;-><init>()V

    .line 49
    .local v1, "vo":Lzeven/unique/vo/MainItemViewVO;
    const-class v2, Lzeven/test/activity/GifActivity;

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setClassName(Ljava/lang/Class;)V

    .line 50
    const-string v2, "Gif"

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setName(Ljava/lang/String;)V

    .line 51
    const-string v2, "a self-defined gif view"

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setFunction(Ljava/lang/String;)V

    .line 52
    iget-object v2, p0, Lzeven/test/activity/MainActivity;->dataList:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 54
    new-instance v1, Lzeven/unique/vo/MainItemViewVO;

    .end local v1    # "vo":Lzeven/unique/vo/MainItemViewVO;
    invoke-direct {v1}, Lzeven/unique/vo/MainItemViewVO;-><init>()V

    .line 55
    .restart local v1    # "vo":Lzeven/unique/vo/MainItemViewVO;
    const-class v2, Lzeven/test/activity/CalendarDemoActivity;

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setClassName(Ljava/lang/Class;)V

    .line 56
    const-string v2, "Calendar"

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setName(Ljava/lang/String;)V

    .line 57
    const-string v2, "gridView ,animation,ViewFlipper\uff0cOnGestureListener"

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setFunction(Ljava/lang/String;)V

    .line 58
    iget-object v2, p0, Lzeven/test/activity/MainActivity;->dataList:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 60
    new-instance v1, Lzeven/unique/vo/MainItemViewVO;

    .end local v1    # "vo":Lzeven/unique/vo/MainItemViewVO;
    invoke-direct {v1}, Lzeven/unique/vo/MainItemViewVO;-><init>()V

    .line 61
    .restart local v1    # "vo":Lzeven/unique/vo/MainItemViewVO;
    const-class v2, Lzeven/test/activity/CameraDemoActivity;

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setClassName(Ljava/lang/Class;)V

    .line 62
    const-string v2, "Camera"

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setName(Ljava/lang/String;)V

    .line 63
    const-string v2, "shape,SurfaceView,camera"

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setFunction(Ljava/lang/String;)V

    .line 64
    iget-object v2, p0, Lzeven/test/activity/MainActivity;->dataList:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 66
    new-instance v1, Lzeven/unique/vo/MainItemViewVO;

    .end local v1    # "vo":Lzeven/unique/vo/MainItemViewVO;
    invoke-direct {v1}, Lzeven/unique/vo/MainItemViewVO;-><init>()V

    .line 67
    .restart local v1    # "vo":Lzeven/unique/vo/MainItemViewVO;
    const-class v2, Lzeven/test/activity/FlipperDemoActivity;

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setClassName(Ljava/lang/Class;)V

    .line 68
    const-string v2, "Flipper"

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setName(Ljava/lang/String;)V

    .line 69
    const-string v2, "animation,ViewFlipper\uff0cOnGestureListener"

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setFunction(Ljava/lang/String;)V

    .line 70
    iget-object v2, p0, Lzeven/test/activity/MainActivity;->dataList:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 72
    new-instance v1, Lzeven/unique/vo/MainItemViewVO;

    .end local v1    # "vo":Lzeven/unique/vo/MainItemViewVO;
    invoke-direct {v1}, Lzeven/unique/vo/MainItemViewVO;-><init>()V

    .line 73
    .restart local v1    # "vo":Lzeven/unique/vo/MainItemViewVO;
    const-class v2, Lzeven/test/activity/GridViewLayoutActivity;

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setClassName(Ljava/lang/Class;)V

    .line 74
    const-string v2, "GridView"

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setName(Ljava/lang/String;)V

    .line 75
    const-string v2, "layout of gridview"

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setFunction(Ljava/lang/String;)V

    .line 76
    iget-object v2, p0, Lzeven/test/activity/MainActivity;->dataList:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 78
    new-instance v1, Lzeven/unique/vo/MainItemViewVO;

    .end local v1    # "vo":Lzeven/unique/vo/MainItemViewVO;
    invoke-direct {v1}, Lzeven/unique/vo/MainItemViewVO;-><init>()V

    .line 79
    .restart local v1    # "vo":Lzeven/unique/vo/MainItemViewVO;
    const-class v2, Lzeven/test/activity/HorizontalListViewDemoActivity;

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setClassName(Ljava/lang/Class;)V

    .line 80
    const-string v2, "Horizontal Scroll"

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setName(Ljava/lang/String;)V

    .line 81
    const-string v2, "imageView , scroll in horizontal direction"

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setFunction(Ljava/lang/String;)V

    .line 82
    iget-object v2, p0, Lzeven/test/activity/MainActivity;->dataList:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 84
    new-instance v1, Lzeven/unique/vo/MainItemViewVO;

    .end local v1    # "vo":Lzeven/unique/vo/MainItemViewVO;
    invoke-direct {v1}, Lzeven/unique/vo/MainItemViewVO;-><init>()V

    .line 85
    .restart local v1    # "vo":Lzeven/unique/vo/MainItemViewVO;
    const-class v2, Lzeven/test/activity/TitanicDemoActivity;

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setClassName(Ljava/lang/Class;)V

    .line 86
    const-string v2, "Titanic Loading Animation"

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setName(Ljava/lang/String;)V

    .line 87
    const-string v2, "animation,shape"

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setFunction(Ljava/lang/String;)V

    .line 88
    iget-object v2, p0, Lzeven/test/activity/MainActivity;->dataList:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 92
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_b0
    const/16 v2, 0xc8

    if-ge v0, v2, :cond_d0

    .line 93
    new-instance v1, Lzeven/unique/vo/MainItemViewVO;

    .end local v1    # "vo":Lzeven/unique/vo/MainItemViewVO;
    invoke-direct {v1}, Lzeven/unique/vo/MainItemViewVO;-><init>()V

    .line 94
    .restart local v1    # "vo":Lzeven/unique/vo/MainItemViewVO;
    const-class v2, Lzeven/test/activity/CalendarDemoActivity;

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setClassName(Ljava/lang/Class;)V

    .line 95
    const-string v2, "Calendar"

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setName(Ljava/lang/String;)V

    .line 96
    const-string v2, "gridView ,animation,ViewFlipper\uff0cOnGestureListener"

    invoke-virtual {v1, v2}, Lzeven/unique/vo/MainItemViewVO;->setFunction(Ljava/lang/String;)V

    .line 97
    iget-object v2, p0, Lzeven/test/activity/MainActivity;->dataList:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 92
    add-int/lit8 v0, v0, 0x1

    goto :goto_b0

    .line 100
    :cond_d0
    return-void
.end method

.method private showList()V
    .registers 4

    .prologue
    .line 42
    new-instance v0, Lzeven/test/activity/adapter/MainListViewAdater;

    iget-object v1, p0, Lzeven/test/activity/MainActivity;->dataList:Ljava/util/ArrayList;

    const v2, 0x7f03000e

    invoke-direct {v0, p0, v1, v2}, Lzeven/test/activity/adapter/MainListViewAdater;-><init>(Landroid/content/Context;Ljava/util/List;I)V

    .line 43
    .local v0, "adater":Lzeven/test/activity/adapter/MainListViewAdater;
    iget-object v1, p0, Lzeven/test/activity/MainActivity;->mainList:Landroid/widget/ListView;

    invoke-virtual {v1, v0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 44
    invoke-virtual {v0}, Lzeven/test/activity/adapter/MainListViewAdater;->notifyDataSetChanged()V

    .line 45
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .registers 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 27
    const-wide v0, 0x4044089f1ffeaba0L    # 40.067356109

    .line 28
    .local v0, "a":D
    const-wide v2, 0x405d0efcbff9d599L    # 116.23417663

    .line 29
    .local v2, "b":D
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 30
    const/4 v4, 0x1

    invoke-virtual {p0, v4}, Lzeven/test/activity/MainActivity;->requestWindowFeature(I)Z

    .line 31
    const v4, 0x7f030007

    invoke-virtual {p0, v4}, Lzeven/test/activity/MainActivity;->setContentView(I)V

    .line 32
    invoke-static {p0}, Lbutterknife/ButterKnife;->bind(Landroid/app/Activity;)V

    .line 33
    invoke-direct {p0}, Lzeven/test/activity/MainActivity;->init()V

    .line 34
    invoke-direct {p0}, Lzeven/test/activity/MainActivity;->showList()V

    .line 35
    const-class v4, Lzeven/test/activity/GridViewLayoutActivity;

    invoke-virtual {p0, v4}, Lzeven/test/activity/MainActivity;->setStartActivity(Ljava/lang/Class;)V

    .line 36
    return-void
.end method

.method public setStartActivity(Ljava/lang/Class;)V
    .registers 3
    .param p1, "clazz"    # Ljava/lang/Class;

    .prologue
    .line 38
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p0, p1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 39
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lzeven/test/activity/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 40
    return-void
.end method
