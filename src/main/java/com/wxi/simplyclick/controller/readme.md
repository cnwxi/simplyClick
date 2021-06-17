> <h2>分工</h2>
> - 王向宇：adminController、RedirectController
> - 兰金荣：RootController、SearchController<
> - 陈奇：UserController

> <h2>整合修改</h2>
> <p>王向宇</p>

> <h2>接口列表</h2>
> <h3>admin</h3>
> - /admin/delFilm/{filmId} `删除电影`
> - /admin/addFilm `添加电影`
> - /admin/updFilm/{filmID} `更新电影`
> - /admin/addBelong/{filmID} `添加所属类型`
> - /admin/delBelong/{filmId}&{filmType} `删除所属类型`
> - /admin/updBelong `更新所属类型`
> - /admin/addParticipation{filmId} `添加参演信息`
> - /admin/delParticipation/{filmId}&{castId}&{role}&{character} `删除参演信息`
> - /admin/updParticipation/{filmId}/{filmName}/{castId}/{castName}/{oldRole}/{oldCharacter} `更新参演信息`
> - /admin/addCast `添加演职人员`
> - /admin/delCast/{castId} `删除演职人员`
> - /admin/updCast/{castId} `更新演职人员`
> - /admin/addType/{type} `添加类型`
> - /admin/delType/{type} `删除类型`
> - /admin/updType `更新类型`
>
> <h3>root</h3>
> - /root/delUser/{username} `删除用户`
> - /root/updUser/{username} `更新用户`
> - /root/addUser `添加用户`
> - /root/delComment/{username}/{filmId} `删除评论`
> - /root/banComment/{username}/{filmId} `屏蔽评论`
>
> <h3>search</h3>
> - /search/filmByCastName/{castName} `根据演职人员查询电影`
> - /search/filmByCastName1 `同上`
> - /search/filmByFilmName/{filmName} `根据电影名称查询电影`
> - /search/filmByFilmName1 `同上`
> - /search/film `根据传入参数根据电影名称或演职人员名称搜索`
> - /search/filmByType/{filmType} `根据电影类型查询电影`
> - /search/filmDetail/{filmId} `插叙具体的电影信息`
> - /search/users `查询所有用户 管理员和普通用户`
>
> <h3>user</h3>
> - /user/login `登录`
> - /user/logout `登出`
> - /user/register `注册`
> - /user/forget `忘记密码`
> - /user/profile `进入个人主页`
> - /user/update `更新用户信息`
> - /user/comment/add/{filmId} `添加评论`
> - /user/comment/del/{filmId} `删除评论`
>
> <h3>forward</h3>
> - /forward/rootUserPage `跳转至用户管理页`
> - /forward/adminFilmPage `跳转至电影管理页`
> - /forward/adminCastPage `跳转至演职人员管理页`
> - /forward/filmEdit `跳转电影增加页`
> - /forward/index `跳转网站首页`
> - /forward/castAdd `跳转演职人员增加页`
> - /forward/homePage `跳转首页`
> - /forward/userModify `跳转用户修改信息页`
> - /forward/DetailsEdit/{filmId} `跳转admin修改电影信息页`
> - /forward/castUpdate/{castId} `跳转admin修改演职人员页`
> - /forward/participationUpdate/{filmId}/{filmName}/{castId}/{castName}/{role}/{character} `跳转admin更新参演信息页`
> - /forward/participationAdd `跳转admin添加参演信息页`
> - /forward/participationAdd1/{filmId}
> - /forward/adminParticipationPage `跳转参演信息管理页`
> - /forward/adminParticipationPage1/{filmId} `跳转某部电影的参演信息管理页`
> - /forward/userAdd `跳转root添加用户页`
> - /forward/userUpdate/{username} `跳转root更新用户信息页`
> - /forward/adminParticipationPageUpdate/{filmId}/{filmName}/{castId}/{castName}/{role}/{character}
> - /forward/userCommentRoot/{username} `跳转root视角的用户主页`