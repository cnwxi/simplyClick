# controller层

> <h2>常用注释</h2>
> <p>@Controller ——调用mvc返回网页</p>
> <p>@RestController ——返回字符串</p>
> <p>@RequestMapping ——映射请求</p>
> <p>@RequestParam ——请求参数</p>
> <p>@PathVariable ——请求参数</p>
> <p>返回参数 Model model.addAttribute</p>

> <h2>分工</h2>
> <p>王向宇：adminController、RedirectController</p>
> <p>兰金荣：RootController、SearchController</p> 
> <p>陈奇：UserController</p>

> <h2>整合修改</h2>
> <p>王向宇</p>

> <h2>接口列表</h2>
> <h3>admin</h3>
> - /admin/delFilm/{filmId} `删除电影`
> - /admin/addFilm `添加电影`
> - /admin/updFilm `更新电影`
> - /admin/addBelong `添加所属类型`
> - /admin/delBelong/{filmId}&{filmType} `删除所属类型`
> - /admin/updBelong `更新所属类型`
> - /admin/addParticipation `添加参演信息`
> - /admin/delParticipation/{filmId}&{castId}&{role}&{character} `删除参演信息`
> - /admin/updParticipation `更新参演信息`
> - /admin/addCast `添加演职人员`
> - /admin/delCast/{castId} `删除演职人员`
> - /admin/updCast `更新演职人员`
> - /admin/addType/{type} `添加类型`
> - /admin/delType/{type} `删除类型`
> - /admin/updType `更新类型`
>
> <h3>root</h3>
> - /root/delUser/{username} `删除用户`
> - /root/updUser `更新用户`
> - /root/addUser `添加用户`
> - /root/delComment/{username}&{filmId} `删除评论`
> - /root/banComment/{username}&{filmId} `屏蔽评论`
> 
> <h3>search</h3>
> - /search/filmByCastName/{castName} `根据演职人员查询电影`
> - /search/filmByCastName `同上`
> - /search/filmByFilmName/{filmName} `根据电影名称查询电影`
> - /search/filmByFilmName `同上`
> - /search/filmByType/{filmType} `根据电影类型查询电影`
> - /search/filmDetail/{filmId} `插叙具体的电影信息`
> - /search/users `查询所有用户 管理员和普通用户`
> - /search/userByUsername/{username} `根据用户名查询用户信息`
>
> <h3>user</h3>
> - /user/login `登录`
> - /user/register `注册`
> - /user/forget `忘记密码`
> - /user/profile `进入个人主页`
> - /user/comment/add `添加评论`
> - /user/comment/del `删除评论`
> - /user/comment/upd `更新评论`
>
> <h3>forward</h3>
> - /forward/userManger `跳转至用户管理页`
> - /forward/FilmManage `跳转至电影管理页`
> - /forward/CastManage `跳转至演职人员管理页`
> - /forward/index `跳转网站首页`