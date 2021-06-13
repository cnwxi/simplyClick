
> <h2>分工</h2>
> <p>王向宇：adminController、RedirectController</p>
> <p>兰金荣：RootController、SearchController</p> 
> <p>陈奇：UserController</p>

> <h2>整合修改</h2>
> <p>王向宇</p>

> <h2>接口列表</h2>
> <h3>admin</h3>
> - <p>/admin/delFilm/{filmId} `删除电影`</p>
> - <p>/admin/addFilm `添加电影`</p>
> - <p>/admin/updFilm `更新电影`</p>
> - <p>/admin/addBelong `添加所属类型`</p>
> - <p>/admin/delBelong/{filmId}&{filmType} `删除所属类型`</p>
> - <p>/admin/updBelong `更新所属类型`</p>
> - <p>/admin/addParticipation `添加参演信息`</p>
> - <p>/admin/delParticipation/{filmId}&{castId}&{role}&{character} `删除参演信息`</p>
> - <p>/admin/updParticipation `更新参演信息`</p>
> - <p>/admin/addCast `添加演职人员`</p>
> - <p>/admin/delCast/{castId} `删除演职人员`</p>
> - <p>/admin/updCast `更新演职人员`</p>
> - <p>/admin/addType/{type} `添加类型`</p>
> - <p>/admin/delType/{type} `删除类型`</p>
> - <p>/admin/updType `更新类型`</p>
>
> <h3>root</h3>
> - <p>/root/delUser/{username} `删除用户`</p>
> - <p>/root/updUser `更新用户`</p>
> - <p>/root/addUser `添加用户`</p>
> - <p>/root/delComment/{username}&{filmId} `删除评论`</p>
> - <p>/root/banComment/{username}&{filmId} `屏蔽评论`</p>
>
> <h3>search</h3>
> - <p>/search/filmByCastName/{castName} `根据演职人员查询电影`</p>
> - <p>/search/filmByCastName `同上`</p>
> - <p>/search/filmByFilmName/{filmName} `根据电影名称查询电影`</p>
> - <p>/search/filmByFilmName `同上`</p>
> - <p>/search/filmByType/{filmType} `根据电影类型查询电影`</p>
> - <p>/search/filmDetail/{filmId} `插叙具体的电影信息`</p>
> - <p>/search/users `查询所有用户 管理员和普通用户`</p>
> - <p>/search/userByUsername/{username} `根据用户名查询用户信息`</p>
>
> <h3>user</h3>
> - <p>/user/login `登录`</p>
> - <p>/user/register `注册`</p>
> - <p>/user/forget `忘记密码`</p>
> - <p>/user/profile `进入个人主页`</p>
> - <p>/user/comment/add `添加评论`</p>
> - <p>/user/comment/del `删除评论`</p>
> - <p>/user/comment/upd `更新评论`</p>
>
> <h3>forward</h3>
> - /forward/userManger `跳转至用户管理页`</p>
> - /forward/filmManage `跳转至电影管理页`</p>
> - /forward/castManage `跳转至演职人员管理页`</p>
> - /forward/index `跳转网站首页`</p>