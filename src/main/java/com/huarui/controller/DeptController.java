package com.huarui.controller;



import com.huarui.es.service.MenuService;
import com.huarui.es.service.NovelService;
import com.huarui.es.type.Menu;
import com.huarui.es.type.Novel;
import com.huarui.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DeptController
{

	@Autowired
	private DishService dishService;

	public static 		String s = "{\"resultcode\":\"200\",\"reason\":\"Success\",\"result\":{\"data\":[{\"id\":\"30464\",\"title\":\"牛丸蛋炒饭\",\"tags\":\"咸;10-20分钟;炒;饭;套餐;全菜系;3-4人;经济实惠;特色饭;炒锅\",\"imtro\":\"明明是一份蛋炒饭 不过加了牛肉丸后 就变成了牛丸蛋炒饭 整个感觉上，味道上都更加赞了 这样子的炒饭，你们喜欢吗 喜欢也来尝上一口吧\",\"ingredients\":\"冷饭,600g;鸡蛋,2个;牛肉丸,4个\",\"burden\":\"葱,适量;细盐,适量;料酒,适量\",\"albums\":[\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/t\\/31\\/30464_200312.jpg\"],\"steps\":[{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/305\\/30464_7829965eef175c2f.jpg\",\"step\":\"1.备牛肉丸，鸡蛋，葱花，冷饭。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/305\\/30464_59e435f8f33f511b.jpg\",\"step\":\"2.热锅加油，入牛肉丸爆香。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/305\\/30464_bba25565deb4fca9.jpg\",\"step\":\"3.将鸡蛋打散在冷饭里，拌至松散。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/305\\/30464_8ab46ac4122e0324.jpg\",\"step\":\"4.牛肉丸爆至出香，外表微干。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/305\\/30464_651c9e94fa8728ff.jpg\",\"step\":\"5.将蛋液冷饭下锅跟牛肉丸同炒。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/305\\/30464_7d0a7c3ae6c6509b.jpg\",\"step\":\"6.加入适量细盐。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/305\\/30464_d90594f46dd89e7c.jpg\",\"step\":\"7.加入适量料酒，炒至入味。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/305\\/30464_15da765df11a5e50.jpg\",\"step\":\"8.转小火，加入葱花。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/305\\/30464_1e2f8d214404ad03.jpg\",\"step\":\"9.再拌炒均匀出味即可。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/305\\/30464_28750405ffc8625f.jpg\",\"step\":\"10.一份香鲜可口的炒饭完成。\"}]},{\"id\":\"76742\",\"title\":\"牛乳磨牙饼\",\"tags\":\"儿童;烤箱;奶香;甜;烤\",\"imtro\":\"给表妹寄饼干吃，这次专门做了适合她家小孩子的牛乳磨牙棒，形状不太好看，但心意比什么都大，对吧。嘿。 很适合用来给长牙期的小朋友哦，无糖的添加，改成用炼乳来代替糖的甜，使得小饼干奶香味十足。\",\"ingredients\":\"低筋面粉,80g;黄油,40g\",\"burden\":\"奶粉,20g;炼乳,40ml\",\"albums\":[\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/t\\/77\\/76742_768069.jpg\"],\"steps\":[{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/768\\/76742_e081334e733416a4.jpg\",\"step\":\"1.称好所有配料\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/768\\/76742_e050273f2852d175.jpg\",\"step\":\"2.软化的黄油、奶粉、炼乳一起放入碗里，用刮刀搅拌均匀\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/768\\/76742_ef4c20a3a4a6aab0.jpg\",\"step\":\"3.筛入低粉\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/768\\/76742_fc5b520b0cef2fbd.jpg\",\"step\":\"4.用刮刀拌匀或直接用手揉成面团\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/768\\/76742_f67af47a5b3929c7.jpg\",\"step\":\"5.将面团放入保鲜袋内，更加容易整形\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/768\\/76742_920b0f8f8195b3bf.jpg\",\"step\":\"6.用擀面杖擀成厚度为0.3CM的长方形状面片\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/768\\/76742_06968e80384a76cb.jpg\",\"step\":\"7.切成均匀的细条\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/768\\/76742_c24c786f8d1f4905.jpg\",\"step\":\"8.把细条摆放在烤盘上\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/768\\/76742_361e9d533af51c79.jpg\",\"step\":\"9.放入预热好180℃的烤箱，烤10分钟左右，至金黄色即可\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/768\\/76742_7d3a73a6cbe82dab.jpg\",\"step\":\"10.适合小朋友的，浓香小饼干来咯\"}]},{\"id\":\"79\",\"title\":\"牛仔骨烧土豆\",\"tags\":\"家常菜;增肥;炖;冬季;香辣;增强抵抗力;健脾;祛风散寒;祛寒;健脾胃;助睡眠;脾虚\",\"imtro\":\"牛仔骨中所含的人体所需元素，是最多最高最丰富的。其中包括：蛋白质、血质铁、维生素、锌、磷及多种胺基酸。牛仔骨炖土豆，用最家常最被百姓接受的做法，香浓好味。 牛仔骨是牛的小排，炖汤红烧都不错，我们这里牛仔骨25一斤，猪小排23，我是宁愿选择牛仔骨了。\",\"ingredients\":\"牛仔骨,800g;土豆,2个\",\"burden\":\"胡萝卜,1根;青椒,2个;姜,2块;干辣椒,8个;葱,1段;八角,2个;生抽,1汤匙;老抽,1\\/2汤匙;盐,适量;牛肉酱,1汤匙\",\"albums\":[\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/t\\/1\\/79_709935.jpg\"],\"steps\":[{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/1\\/79_05e3c7cbaf25a056.jpg\",\"step\":\"1.原料。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/1\\/79_8c0b6cd677782a16.jpg\",\"step\":\"2.冷水加牛仔骨，姜块煮开。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/1\\/79_09b53398b22c8a15.jpg\",\"step\":\"3.捞出温水洗净备用。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/1\\/79_befe062d77ee2628.jpg\",\"step\":\"4.姜切片，八角掰碎，葱切段。干辣椒一切二。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/1\\/79_5925e23e150300a4.jpg\",\"step\":\"5.胡萝卜土豆切滚刀块洗净备用。青椒切块。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/1\\/79_8139c0a119915ac3.jpg\",\"step\":\"6.锅里放油，小火炒姜片八角葱。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/1\\/79_a82d27258b4a742b.jpg\",\"step\":\"7.放入牛仔骨，煸炒出水分，肉微黄。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/1\\/79_d1602f1d7480c940.jpg\",\"step\":\"8.放入干辣椒牛肉酱煸炒均匀后，依次料酒，生抽，老抽，翻炒均匀。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/1\\/79_93cde626de65369c.jpg\",\"step\":\"9.兑入温水淹没食材。大火烧开小火炖40-60分钟。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/1\\/79_3daafccb9bd5946f.jpg\",\"step\":\"10.水大概和牛仔骨齐平的时候，放入土豆和胡萝卜，调入盐比自己口味淡一些，大火收汁。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/1\\/79_32b02f13c258fb98.jpg\",\"step\":\"11.还有一点汤汁的时候放入青椒翻炒均匀即可。\"}]},{\"id\":\"8464\",\"title\":\"牛仔骨萝卜煲\",\"tags\":\"粤菜;舌尖;补钙;家常菜;煮\",\"imtro\":\"最近买回来的牛仔骨煎之后口感很硬，于是，将牛仔骨和萝卜一起红烧，只有这样，牛仔骨才软烂。吃起来才没有那么费劲。不过，这样红烧牛仔骨味道还不错。\",\"ingredients\":\"牛仔骨,300g;萝卜,400g\",\"burden\":\"油,适量;盐,适量;老抽,适量;鸡精,适量\",\"albums\":[\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/t\\/9\\/8464_326003.jpg\"],\"steps\":[{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/85\\/8464_d571b9e0a09691d2.jpg\",\"step\":\"1.准备牛仔骨。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/85\\/8464_7720a53e7b5715c3.jpg\",\"step\":\"2.先将牛仔骨用姜，大料清水煮开去血水然后捞起清洗干净。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/85\\/8464_a8c02e714cdb4c18.jpg\",\"step\":\"3.另起锅将清洗干净的牛仔骨放入煮锅加入老抽，料酒，大料，盐，鸡精焖煮至软烂。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/85\\/8464_bfc7185dbacb5f00.jpg\",\"step\":\"4.准备萝卜。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/85\\/8464_f638fb8fb163b084.jpg\",\"step\":\"5.将切片的萝卜放入煮好的牛仔骨里大火烧开至萝卜入味。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/85\\/8464_fd98b17e276faa8b.jpg\",\"step\":\"6.煮至萝卜也软也入味了就可以上桌享用了。\"}]},{\"id\":\"18549\",\"title\":\"牛大力眉豆花生煲猪脚筋\",\"tags\":\"通乳;丰胸;骨质疏松;抗疲劳;健忘;提神;砂锅;增强抵抗力;补钙;健脾;益智;健脑益智;健脑;催乳;下奶;健脾胃;补锌;脑力劳动者;增强记忆力;脾虚\",\"imtro\":\"牛大力 又叫猪脚笠能治肾虚和腰酸背痛以及风湿病， 猪脚筋功效犹如鹿筋，但价钱就相差很多，可以说是物美价廉的强补筋骨的好食材，还美颜润肤呢。 猪脚筋有点油腻，可以用酒抓洗之后用姜水焯过 这样煲出来的汤一点都不油腻啦\",\"ingredients\":\"牛大力,25g;眉豆,60g;花生,60g;猪脚筋,120g;猪扇骨,250g\",\"burden\":\"盐,适量;红枣,5个;陈皮,小块;姜片,4片\",\"albums\":[\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/t\\/19\\/18549_263684.jpg\"],\"steps\":[{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/186\\/18549_8390a575ce567e21.jpg\",\"step\":\"1.牛大力，猪脚筋，扇骨，红枣，眉豆，花生，陈皮，姜片\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/186\\/18549_e6acf0722405bf24.jpg\",\"step\":\"2.眉豆花生提前浸泡，或直接洗净下锅煲都可以。浸泡之后再煲较易煲绵。红枣去核，\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/186\\/18549_800ad3efcfbbdc6b.jpg\",\"step\":\"3.猪脚筋用少量的酒抓洗，放开水锅里焯下 这样煲出来的汤没那么油腻。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/186\\/18549_7596110c6b36f4fc.jpg\",\"step\":\"4.牛大力刮去外皮洗净切薄片，猪脚筋焯过洗净，姜切片\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/186\\/18549_41969d9e2dba3222.jpg\",\"step\":\"5.全部材料放进汤锅 放足够的水 大概2500毫升\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/186\\/18549_1a1454b2f6b72885.jpg\",\"step\":\"6.开大火煲开10分钟 改小火煲2小时\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/186\\/18549_77047d13f1274ee6.jpg\",\"step\":\"7.煲2小时 爱心汤水煲好了 可适当放些盐调味，我们习惯不放盐，更清甜。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/186\\/18549_a9280c65e7299b9e.jpg\",\"step\":\"8.眉豆花生牛大力煲猪脚筋，特别适合体力劳动恢复体力，增强腰肌\"}]},{\"id\":\"33388\",\"title\":\"牛头饺子\",\"tags\":\"面食;早餐;蒸;饺子\",\"imtro\":\"这款牛头饺子是前两天做的，这两天比较忙一直没有时间整理出来。今天好一点把它整理出来和大家一起分享。牛的寓意很好，牛是十二生肖的第二位时。牛处地支第二位，勤勉可靠 任劳任怨 屈强从一。\",\"ingredients\":\"饺子皮,250g;牛腩,250g;芹菜,5棵\",\"burden\":\"油,适量;盐,适量;料酒,1汤勺;味精,2g;生抽,2汤勺\",\"albums\":[\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/t\\/34\\/33388_863925.jpg\"],\"steps\":[{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/334\\/33388_9223af9e34b92fd0.jpg\",\"step\":\"1.材料： 饺子皮250克 馅料：牛腩250克、芹菜5棵、料酒1汤勺、生抽2汤勺、盐3克、味精2克、黑芝麻少许、食用油半汤勺\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/334\\/33388_c263d711489f6087.jpg\",\"step\":\"2.把芹菜和牛腩洗净切小段剁泥\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/334\\/33388_63dbd29185777c55.jpg\",\"step\":\"3.坐锅上火倒入食用油\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/334\\/33388_b0061e505c69f369.jpg\",\"step\":\"4.倒入牛腩\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/334\\/33388_1db8fc8d8826921a.jpg\",\"step\":\"5.炒至出水再倒入料酒\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/334\\/33388_2f538679b47d4fa6.jpg\",\"step\":\"6.倒入生抽\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/334\\/33388_61bcad3a0490a414.jpg\",\"step\":\"7.倒入盐和味精炒至入味\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/334\\/33388_63aec9e42965a29d.jpg\",\"step\":\"8.再倒入切好的芹菜收干汤汁哦\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/334\\/33388_355cce84017335fe.jpg\",\"step\":\"9.把炒好地牛腩起锅备用\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/334\\/33388_d5ded305764574c6.jpg\",\"step\":\"10.取一片饺子皮放入馅料\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/334\\/33388_d556ade7b49b8491.jpg\",\"step\":\"11.在相应的位子，收起四个角捏紧\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/334\\/33388_cb49e774145b10fa.jpg\",\"step\":\"12.右手捏住长端处，左手将长端处的中间推捏成牛的鼻孔\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/334\\/33388_a96a2e2879d5f6c7.jpg\",\"step\":\"13.再依此法将反向的一条边作为牛角 ，把剩下的两条边做耳朵把围处捏连到牛角的根部\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/334\\/33388_7e18239072e6335f.jpg\",\"step\":\"14.在耳朵的前方粘放入黑芝麻、\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/334\\/33388_740f0a00571ead89.jpg\",\"step\":\"15.将水烧开以后把牛头饺子放入锅内蒸5分钟\"}]},{\"id\":\"41047\",\"title\":\"牛奶冰--简单冰品\",\"tags\":\"冰品\",\"imtro\":\"非常简单的一道消暑冰品。 只是用了模具改变一下造型，就可以达到美丽的效果，让人爱不适口。\",\"ingredients\":\"蒙牛奶特,250ml\",\"burden\":\"淀粉,10g;盐,适量\",\"albums\":[\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/t\\/41\\/41047_465548.jpg\"],\"steps\":[{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/411\\/41047_badf199a61f40c76.jpg\",\"step\":\"1.淀粉加少许清水搅拌备用。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/411\\/41047_70861b9b1840e0e9.jpg\",\"step\":\"2.牛奶倒入奶锅中。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/411\\/41047_cb5d63a6e646dd6d.jpg\",\"step\":\"3.微加热关火，加入水淀粉搅拌均匀。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/411\\/41047_614b9e8a2adaa2b5.jpg\",\"step\":\"4.倒入果冻模具中放入冰箱冷冻成牛奶冰即可食用。\"}]},{\"id\":\"41327\",\"title\":\"牛奶冰棍\",\"tags\":\"儿童;冰品;甜;解暑\",\"imtro\":\"现在天一天比一天热了，我家宝宝很喜欢吃冰棍，在外买的怕不卫生，所有就自己在家做了点，虽然没有外面卖的那么甜，但味道还可以，奶的味道很香。\",\"ingredients\":\"牛奶,150g\",\"burden\":\"橙子,适量;冰糖,适量;山楂糕,适量;彩色糖针,适量\",\"albums\":[\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/t\\/42\\/41327_856053.jpg\"],\"steps\":[{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/414\\/41327_cfcd3e9aa42e86c0.jpg\",\"step\":\"1.准备所有食材。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/414\\/41327_da90f6dd0d442c87.jpg\",\"step\":\"2.把冰棍模具洗净。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/414\\/41327_6d639aadf2650e49.jpg\",\"step\":\"3.先把彩针倒入模具盒中。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/414\\/41327_29393e5a3af0ec89.jpg\",\"step\":\"4.再把山楂糕切块放入模具中。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/414\\/41327_26e4198c5e7deafd.jpg\",\"step\":\"5.橙子切好，放入两个格里。在放入几颗冰糖。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/414\\/41327_4682e625acb36d57.jpg\",\"step\":\"6.把牛奶倒入模具中。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/414\\/41327_dc9961b23f04130b.jpg\",\"step\":\"7.八分满。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/414\\/41327_55b7d491a57a0d99.jpg\",\"step\":\"8.盖上盖子，我的缺一个，就用冰棍筷子了。冻一宿即可。\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/414\\/41327_cfb03cb605c212dc.jpg\",\"step\":\"9.可以吃了。\"}]},{\"id\":\"38705\",\"title\":\"牛奶冰棒\",\"tags\":\"儿童;甜;零食;降暑;冰淇琳\",\"imtro\":\"孩子一直喜欢吃冷食，不过不敢多给他吃，尤其现在龋齿很厉害，就更不能给他多吃了，可是现在天气这么，也不能完全的控制，于是就自己动手给宝宝做了这个牛奶冰棒，很简单，也很好吃。图片不是很好，因为拿出来放那我就给忘记了，等想起来已经有点要化了，其实刚做出来是很好的。\",\"ingredients\":\"儿童牛奶,200g\",\"burden\":\"糯米饭,适量\",\"albums\":[\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/t\\/39\\/38705_506198.jpg\"],\"steps\":[{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/388\\/38705_0a2f6451b4ca3511.jpg\",\"step\":\"1.首先准备儿童牛奶，因为这个有点甜，所以就不用加糖了\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/388\\/38705_932e9eabb2f1f5b8.jpg\",\"step\":\"2.然后准备出冰棒模具\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/388\\/38705_433e56c97f956a19.jpg\",\"step\":\"3.适量的糯米饭，没有糯米饭，大米饭也可以\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/388\\/38705_6eea13e0b66f5f24.jpg\",\"step\":\"4.把糯米饭和奶倒入料理机中\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/388\\/38705_4756764edb3fac68.jpg\",\"step\":\"5.把糯米饭稍微打碎一下，也没有必要太碎，根据自己的喜好\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/388\\/38705_5c5787e4c0ff9352.jpg\",\"step\":\"6.分别倒入冰棒磨具中，放入冰箱冷冻室里，冷冻两个小时以上\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/388\\/38705_001cedc179ddb70d.jpg\",\"step\":\"7.随时吃随时就可以取出来，可以室温放置几分钟就可以取出来了\"}]},{\"id\":\"41193\",\"title\":\"牛奶冰棒\",\"tags\":\"冰品;儿童;甜;煮;夏季菜谱\",\"imtro\":\"炎炎的夏日里，热得人懒洋洋的什么事情都不想做。只想吃点冷冷的冰品来降温，就试做了一些小时候吃过的冰棍用来降温，自已做的冰品也是偶而做做，尝试尝试，说句老实话还是没有买的好吃。但是，健康卫生，吃的放心。\",\"ingredients\":\"牛奶,250g\",\"burden\":\"糖,适量;淀粉,适量\",\"albums\":[\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/t\\/42\\/41193_207049.jpg\"],\"steps\":[{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/412\\/41193_8795c8cb95de1687.jpg\",\"step\":\"1.备白糖\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/412\\/41193_bf473c12d35612ce.jpg\",\"step\":\"2.再备牛奶，淀粉\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/412\\/41193_09cc7d973d7f268d.jpg\",\"step\":\"3.汤锅里倒进牛奶\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/412\\/41193_6bf9e46fe19e3016.jpg\",\"step\":\"4.烧开后倒进淀粉烧开，边倒边用快子搅匀\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/412\\/41193_f0cc3a031fd5beb5.jpg\",\"step\":\"5.放进白糖烧开\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/412\\/41193_c356b0c0f99273a9.jpg\",\"step\":\"6.冷却\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/412\\/41193_13fe6b72b985a5b9.jpg\",\"step\":\"7.倒进模具里\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/412\\/41193_d89ef46a8eca82c4.jpg\",\"step\":\"8.插上冰棍\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/412\\/41193_f865863057453e66.jpg\",\"step\":\"9.放进冰箱冷冻\"},{\"img\":\"http:\\/\\/juheimg.oss-cn-hangzhou.aliyuncs.com\\/cookbook\\/s\\/412\\/41193_b1761167d86f115a.jpg\",\"step\":\"10.脱模\"}]}],\"totalNum\":\"672\",\"pn\":0,\"rn\":\"10\"},\"error_code\":0}";



	@Autowired
	MenuService menuService;

	@Autowired
	NovelService novelService;

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") Long id)
	{
//
//		Gson gson = new Gson();
//
//
//		DataDTO dto = gson.fromJson(s,
//				new TypeToken<DataDTO>() {
//				}.getType());
//
//		dishService.inDB(dto);
//		dishService.inDBreturnId();


		return dishService.findById(id).getTitle();

		//return "csrr dish..";

	}

	@RequestMapping(value = "/testUpdate", method = RequestMethod.GET)
	public String testUpdate()
	{


		return "更新接口...";

	}


	@RequestMapping(value = "testEs/{title}/{startPage}/{pageSize}",method = RequestMethod.GET)
	public Object testEs(
			@PathVariable("title") String title,
			@PathVariable("startPage") Integer startPage,
			@PathVariable("pageSize") Integer pageSize
	){



		Page<Menu> page =  menuService.selectByNamePage(title,startPage,pageSize);

		return page.getContent().stream().map(a->a.getId()).collect(Collectors.toList());
		//return page;
	}


	@RequestMapping(value = "addNovel/{id}/{wordCount}/{bookName}/{author}/{brief}",method = RequestMethod.POST)
	public Object addNovel(
			@PathVariable("id") Long  id,
			@PathVariable("wordCount") Integer  wordCount,
			@PathVariable("bookName") String  bookName,
			@PathVariable("author") String author,
			@PathVariable("brief") String brief
	){

		novelService.addNovel(id,wordCount,bookName,author,brief);

		return "添加成功...";
	}

	@RequestMapping(value = "selectNovel/{query}",method = RequestMethod.GET)
	public Object addNovel(
			@PathVariable("query") String  query
			){



		Page<Novel> list = novelService.selectNovel(query);

		return list;
	}








}
