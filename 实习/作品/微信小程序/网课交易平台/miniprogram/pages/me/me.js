// pages/me/me.js
const app = getApp()
const db = wx.cloud.database() //获取云数据库的实例
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {
    if (app.globalData.userInfo) {
    this.setData({
    userInfo: app.globalData.userInfo,
    hasUserInfo: true
    })
    } else if (this.data.canIUse) {
    // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
    // 所以此处加入 callback 以防止这种情况
    app.userInfoReadyCallback = res => {
    this.setData({
    userInfo: res.userInfo,
    hasUserInfo: true
    })
    }
    } else {
    // 在没有 open-type=getUserInfo 版本的兼容处理
    wx.getUserInfo({
    success: res => {
    app.globalData.userInfo = res.userInfo
    this.setData({
    userInfo: res.userInfo,
    hasUserInfo: true
    })
    }
    })
    }
    },
    getUserInfo: function (e) {
      app.globalData.userInfo = e.detail.userInfo
      this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
      })
      },


  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },
  bindGetUserInfo: function (res) {
    let info = res;
    console.log(info);
    if (info.detail.userInfo) {
    console.log("点击了同意授权");
    var that = this
    wx.login({
    success: function (res) {
    if (res.code) {
    wx.request({
    url: 'http://fa.com/api/schoolreserve/login',
    data: {
    code: res.code,
    user_info: info.detail.userInfo
    },
    header: {
    'content-type': 'application/json' // 默认值
    },
    success: function (res) {
    var userinfo = {};
    userinfo['id'] = res.data.id;
    userinfo['nickName'] = info.detail.userInfo.nickName;
    userinfo['avatarUrl'] = info.detail.userInfo.avatarUrl;
    userinfo['user_data'] = res.data;
    wx.setStorageSync('userinfo', userinfo)
    that.setData({
    userInfo: info.detail.userInfo
    })
    wx.switchTab({
    url: '../toast/toast',
    })
    }
    })
    } else {
    console.log("授权失败");
    }
    },
    })
    
    } else {
    //用户按了拒绝按钮
    wx.showModal({
    title: '警告',
    content: '您点击了拒绝授权，将无法进入小程序，请授权之后再进入!!!',
    showCancel: false,
    confirmText: '返回授权',
    success: function (res) {
    if (res.confirm) {
    console.log('用户点击了“返回授权”')
    }
    }
    })
    }
    }
    })

