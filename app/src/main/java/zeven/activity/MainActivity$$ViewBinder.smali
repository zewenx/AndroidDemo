.class public Lzeven/test/activity/MainActivity$$ViewBinder;
.super Ljava/lang/Object;
.source "MainActivity$$ViewBinder.java"

# interfaces
.implements Lbutterknife/ButterKnife$ViewBinder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lzeven/test/activity/MainActivity;",
        ">",
        "Ljava/lang/Object;",
        "Lbutterknife/ButterKnife$ViewBinder",
        "<TT;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 8
    .local p0, "this":Lzeven/test/activity/MainActivity$$ViewBinder;, "Lzeven/test/activity/MainActivity$$ViewBinder<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic bind(Lbutterknife/ButterKnife$Finder;Ljava/lang/Object;Ljava/lang/Object;)V
    .registers 4

    .prologue
    .line 8
    .local p0, "this":Lzeven/test/activity/MainActivity$$ViewBinder;, "Lzeven/test/activity/MainActivity$$ViewBinder<TT;>;"
    check-cast p2, Lzeven/test/activity/MainActivity;

    invoke-virtual {p0, p1, p2, p3}, Lzeven/test/activity/MainActivity$$ViewBinder;->bind(Lbutterknife/ButterKnife$Finder;Lzeven/test/activity/MainActivity;Ljava/lang/Object;)V

    return-void
.end method

.method public bind(Lbutterknife/ButterKnife$Finder;Lzeven/test/activity/MainActivity;Ljava/lang/Object;)V
    .registers 7
    .param p1, "finder"    # Lbutterknife/ButterKnife$Finder;
    .param p3, "source"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lbutterknife/ButterKnife$Finder;",
            "TT;",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    .prologue
    .local p0, "this":Lzeven/test/activity/MainActivity$$ViewBinder;, "Lzeven/test/activity/MainActivity$$ViewBinder<TT;>;"
    .local p2, "target":Lzeven/test/activity/MainActivity;, "TT;"
    const v2, 0x7f0a000f

    .line 11
    const-string v1, "field \'mainList\'"

    invoke-virtual {p1, p3, v2, v1}, Lbutterknife/ButterKnife$Finder;->findRequiredView(Ljava/lang/Object;ILjava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    .line 12
    .local v0, "view":Landroid/view/View;
    const-string v1, "field \'mainList\'"

    invoke-virtual {p1, v0, v2, v1}, Lbutterknife/ButterKnife$Finder;->castView(Landroid/view/View;ILjava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/widget/ListView;

    iput-object v1, p2, Lzeven/test/activity/MainActivity;->mainList:Landroid/widget/ListView;

    .line 13
    return-void
.end method

.method public bridge synthetic unbind(Ljava/lang/Object;)V
    .registers 2

    .prologue
    .line 8
    .local p0, "this":Lzeven/test/activity/MainActivity$$ViewBinder;, "Lzeven/test/activity/MainActivity$$ViewBinder<TT;>;"
    check-cast p1, Lzeven/test/activity/MainActivity;

    invoke-virtual {p0, p1}, Lzeven/test/activity/MainActivity$$ViewBinder;->unbind(Lzeven/test/activity/MainActivity;)V

    return-void
.end method

.method public unbind(Lzeven/test/activity/MainActivity;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 16
    .local p0, "this":Lzeven/test/activity/MainActivity$$ViewBinder;, "Lzeven/test/activity/MainActivity$$ViewBinder<TT;>;"
    .local p1, "target":Lzeven/test/activity/MainActivity;, "TT;"
    const/4 v0, 0x0

    iput-object v0, p1, Lzeven/test/activity/MainActivity;->mainList:Landroid/widget/ListView;

    .line 17
    return-void
.end method
