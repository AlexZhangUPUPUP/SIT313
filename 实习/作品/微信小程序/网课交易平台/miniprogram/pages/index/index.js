//index.js
//获取应用实例
const db = wx.cloud.database()
const app = getApp()

Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    //Slideshow iamge
    "bnrUrl": [
      { "url": "/images/ad1.jpg" }, { "url": "/images/ad2.jpg" }, { "url": "/images/ad4.jpg" }, { "url": "/images/ad3.jpg" }
    ],
    list: [],
  },
  //事件处理函数
  bindViewTap: function () {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },

  getList() {
    db.collection('item').get({
      success: res => {
        console.log(res.data)
        this.setData({
          list: res.data
        })
      }
    })
  },

  onLoad() {
    this.page = 0
    this.getList(false)
    //转发API
    wx.showShareMenu()
  }
})
