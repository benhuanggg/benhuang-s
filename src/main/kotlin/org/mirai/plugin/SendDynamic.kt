package org.mirai.plugin

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import net.mamoe.mirai.console.command.CommandManager.INSTANCE.commandPrefix
import net.mamoe.mirai.console.command.CompositeCommand
import net.mamoe.mirai.console.command.MemberCommandSenderOnMessage
import net.mamoe.mirai.console.util.ConsoleExperimentalApi
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import org.jsoup.Jsoup
import java.net.URL
import java.text.SimpleDateFormat

@ConsoleExperimentalApi
object SendDynamic : CompositeCommand(
    PluginMain, "SendDynamic", "动态查询",
    description = "B站动态查询"
) {
    override val usage: String =
        "$commandPrefix $primaryName <目标ID> [回溯条数]\n" +
            "目标ID列表：\n" +
            "*1* 小加加,火星加,碧蓝公告\n" +
            "*2* 阿米娅,方舟公告,罗德岛线报\n" +
            "*3* 呆毛王,FGO公告,月球人公告\n" +
            "*4* 派蒙,原神公告,冒险家情报\n" +
            "*5* UID,其他"

    @SubCommand("小加加", "火星加", "碧蓝公告", "1")
    suspend fun MemberCommandSenderOnMessage.azurLane() {
        val (timeStamp, text, images) = getDynamic(233114659)
        val time = SimpleDateFormat("YY-MM-dd HH:mm").format(timeStamp)
//        if (images?.isEmpty() == true){
//            TB.logger.info{"有图"}
//            text?.let { sendMessage("$it\n发布时间:$time") }
//            for(img in images){
//                subject.sendImage(img)
//            }
//            val image = ExternalResource.
//            val chain = buildMessageChain{
//                text?.let { PlainText("$it\n附图：\n发布时间:$time") }
//                images[0].toExternalResource()
//            sendMessage(chain)
//            }
//        for (image in images){
//            val s = image.toExternalResource()
//
//        }
//        }else{
        images?.let { subject.sendImage(it) }
        text?.let { sendMessage("$it\n发布时间:$time") }
//        }
//        sendMessage(getDynamic(233114659))
    }

    @SubCommand("小加加", "火星加", "碧蓝公告", "1")
    suspend fun MemberCommandSenderOnMessage.azurLane(index: Int) {
        if (index >= 10) {
            sendMessage("最多只能往前10条哦\n的(￣﹃￣)")
            return
        } else if (index < 0) {
            sendMessage("未来的事情我怎么会知道\n=￣ω￣=")
            return
        }
        val (timeStamp, text, images) = getDynamic(233114659, index)
        val time = SimpleDateFormat("YY-MM-DD hh:mm").format(timeStamp)
//        if (images?.isEmpty() == true){
//            val f = images[0].toExternalResource()
//            val chain = buildMessageChain{
//                text?.let { PlainText("$it\n发布时间:$time") }
//                add(subject.uploadImage(f))
//            }
//            f.close()
//            sendMessage(chain)
//        for (image in images){
//            val s = image.toExternalResource()
//
//        }
//        }else{
        images?.let { subject.sendImage(it) }
        text?.let { sendMessage("$it\n发布时间:$time") }
//        }
    }

    @SubCommand("阿米娅", "方舟公告", "罗德岛线报", "2")
    suspend fun MemberCommandSenderOnMessage.arKnights() {
        val (timeStamp, text, images) = getDynamic(161775300)
        val time = SimpleDateFormat("YY-MM-DD hh:mm").format(timeStamp)
        images?.let { subject.sendImage(it) }
        text?.let { sendMessage("$it\n发布时间:$time") }
    }

    @SubCommand("阿米娅", "方舟公告", "罗德岛线报", "2")
    suspend fun MemberCommandSenderOnMessage.arKnights(index: Int) {
        if (index >= 10) {
            sendMessage("最多只能往前10条哦\n的(￣﹃￣)")
            return
        } else if (index < 0) {
            sendMessage("未来的事情我怎么会知道\n=￣ω￣=")
            return
        }
        val (timeStamp, text, images) = getDynamic(161775300, index)
        val time = SimpleDateFormat("YY-MM-DD hh:mm").format(timeStamp)
        images?.let { subject.sendImage(it) }
        text?.let { sendMessage("$it\n发布时间:$time") }
    }

    @SubCommand("呆毛王", "FGO公告", "月球人公告", "3")
    suspend fun MemberCommandSenderOnMessage.fateGrandOrder() {
        val (timeStamp, text, images) = getDynamic(233108841)
        val time = SimpleDateFormat("YY-MM-DD hh:mm").format(timeStamp)
        images?.let { subject.sendImage(it) }
        text?.let { sendMessage("$it\n发布时间:$time") }
    }

    @SubCommand("呆毛王", "FGO公告", "月球人公告", "3")
    suspend fun MemberCommandSenderOnMessage.fateGrandOrder(index: Int) {
        if (index >= 10) {
            sendMessage("最多只能往前10条哦\n的(￣﹃￣)")
            return
        } else if (index < 0) {
            sendMessage("未来的事情我怎么会知道\n=￣ω￣=")
            return
        }
        val (timeStamp, text, images) = getDynamic(233108841, index)
        val time = SimpleDateFormat("YY-MM-DD hh:mm").format(timeStamp)
        images?.let { subject.sendImage(it) }
        text?.let { sendMessage("$it\n发布时间:$time") }
    }

    @SubCommand("派蒙", "原神公告", "冒险家情报", "4")
    suspend fun MemberCommandSenderOnMessage.genShin() {
        val (timeStamp, text, images) = getDynamic(401742377)
        val time = SimpleDateFormat("YY-MM-DD hh:mm").format(timeStamp)
        images?.let { subject.sendImage(it) }
        text?.let { sendMessage("$it\n发布时间:$time") }
    }

    @SubCommand("派蒙", "原神公告", "冒险家情报", "4")
    suspend fun MemberCommandSenderOnMessage.genShin(index: Int) {
        if (index >= 10) {
            sendMessage("最多只能往前10条哦\n的(￣﹃￣)")
            return
        } else if (index < 0) {
            sendMessage("未来的事情我怎么会知道\n=￣ω￣=")
            return
        }
        val (timeStamp, text, images) = getDynamic(401742377, index)
        val time = SimpleDateFormat("YY-MM-DD hh:mm").format(timeStamp)
        images?.let { subject.sendImage(it) }
        text?.let { sendMessage("$it\n发布时间:$time") }
    }

    @SubCommand("UID", "其他", "5")
    suspend fun MemberCommandSenderOnMessage.other(uid: Int) {
        val (timeStamp, text, images) = getDynamic(uid)
        val time = SimpleDateFormat("YY-MM-DD hh:mm").format(timeStamp)
        images?.let { subject.sendImage(it) }
        text?.let { sendMessage("$it\n发布时间:$time") }
    }

    @SubCommand("UID", "其他", "5")
    suspend fun MemberCommandSenderOnMessage.other(uid: Int, index: Int) {
        if (index >= 10) {
            sendMessage("最多只能往前10条哦\n(￣﹃￣)")
            return
        } else if (index < 0) {
            sendMessage("未来的事情我怎么会知道\n=￣ω￣=")
            return
        }
        val (timeStamp, text, images) = getDynamic(uid, index)
        val time = SimpleDateFormat("YY-MM-DD hh:mm").format(timeStamp)
        images?.let { subject.sendImage(it) }
        text?.let { sendMessage("$it\n发布时间:$time") }
    }

    fun getDynamic(uid: Int, index: Int = 0, flag: Boolean = false): Dynamic {
        val doc = Jsoup.connect("https://api.vc.bilibili.com/dynamic_svr/v1/dynamic_svr/space_history?host_uid=$uid")
            .ignoreContentType(true)
            .execute().body().toString()
        val jsonObj = Parser.default().parse(StringBuilder(doc)) as JsonObject
        val desc = jsonObj.obj("data")
            ?.array<JsonObject>("cards")?.get(index)
            ?.obj("desc")
        val timestamp = desc?.long("timestamp")?.times(1000)
        if (flag) {
//            PluginMain.logger.info { "开始判断时间" }
            timestamp?.let {
                val oldTime = MyPluginData.timeStampOfDynamic[uid] ?: 0
                if (oldTime >= it) return Dynamic(null, null, null)
//                PluginMain.logger.info { "准备更新数据" }
                MyPluginData.timeStampOfDynamic[uid] = it
//                PluginMain.logger.info { "数据更新完毕" }
            }
        }
        val typeCode = desc?.int("type")
        val cardStr = jsonObj.obj("data")
            ?.array<JsonObject>("cards")?.get(index)
            ?.string("card")
        val card = Parser.default().parse(StringBuilder(cardStr)) as JsonObject
        when (typeCode) {
            // 无效数据
            0 -> return Dynamic(timestamp, "没有相关动态信息", null)
            // 转发
            1 -> return Dynamic(timestamp, "转发并评论：${card.obj("item")?.string("content")}", null)
            // 含图动态
            2 -> {
                val description = card.obj("item")?.string("description")   // 描述
                val imgSrc = card.obj("item")?.array<JsonObject>("pictures")?.string("img_src")?.toTypedArray()
//                TB.logger.info{"${imgSrc?.get(0)}"}
                if (imgSrc != null) {
//                    val images = mutableListOf<InputStream>()
//                    for(url in imgSrc){
//                        images.add(URL(url).openConnection().getInputStream())
//                    }
//                    return Dynamic(timestamp,description,images)
                    return Dynamic(timestamp, description, URL(imgSrc[0]).openConnection().getInputStream())
                }
                return Dynamic(timestamp, description, null)
            }
            // 无图动态
            4 -> return Dynamic(timestamp, "更新动态：${card.obj("item")?.string("content")}", null)
            // 视频
            8 -> {
                val dynamic = card.string("dynamic") // 描述
                val imgSrc = card.string("pic")      //封面图片
                return Dynamic(timestamp, dynamic, URL(imgSrc).openConnection().getInputStream())
//                return Dynamic(timestamp,dynamic, mutableListOf(URL(imgSrc).openConnection().getInputStream()))
            }
            // 专栏
            64 -> {
                val title = card.string("title")       // 标题
                val summary = card.string("summary")   // 摘要
                val imgSrc = card.string("banner_url") // 封面图片
                return Dynamic(
                    timestamp,
                    "专栏标题:$title\n专栏摘要：\n$summary…",
                    URL(imgSrc).openConnection().getInputStream()
                )
//                return Dynamic(timestamp,"专栏标题:$title\n专栏摘要：\n$summary…", mutableListOf(URL(imgSrc).openConnection().getInputStream()))
            }
            // 卡片
            2048 -> {
                val title = card.obj("sketch")?.string("title")          // 标题
                val context = card.obj("vest")?.string("content")        // 内容
                val targetURL = card.obj("sketch")?.string("target_url") // 相关链接
                return Dynamic(timestamp, "动态标题:$title\n动态内容：\n$context\n相关链接:\n$targetURL", null)
            }
            // 未知类型
            else -> {
                PluginMain.logger.warning("错误信息:未知的类型码 $typeCode ")
                return Dynamic(timestamp, "是未知的动态类型,无法解析", null)
            }
        }
    }
}