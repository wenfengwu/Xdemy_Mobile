<template>
  <div>
      <detail-header :videoInfo="videoInfo"></detail-header>
      <detail-course :videoInfo="videoInfo"></detail-course>
      <detail-tab :chapterList="chapterList" :videoInfo="videoInfo"></detail-tab>
      <footer>
    <router-link :to="{path:'/pay',query:{video_id:this.$route.query.video_id}}" class="user_buy">
                <button>But Now</button>            
     </router-link>
</footer> 

  </div>
</template>

<script>
//import components
import DetailHeader from "./Components/Header";
import DetailCourse from "./Components/Course";
import DetailTab from "./Components/Tab";

import { getVideoDetail } from "@/api/getData.js";

export default {
  //register components
  components: {
    DetailHeader,
    DetailCourse,
    DetailTab,
  },

  data() {
    return {
      //course information
      videoInfo: {},
      //chapters belong to this course
      chapterList: [],
    };
  },

  methods: {
    //get course detail
    async getDetail(vid) {
      try {
        const result = await getVideoDetail(vid);
        if (result.data.code == 0) {
          this.videoInfo = result.data.data;
          this.chapterList = result.data.data.chapter_list;
        }
      } catch (error) {
        console.log(error);
      }
    },
  },

  mounted() {
    //get data after rendering
    console.log(this.$route.query.video_id);
    this.getDetail(this.$route.query.video_id);
  },
};
</script>

<style lang="scss" scoped>
  //footer component
  footer {
    // fixed footer
    position: fixed;
    bottom: 0;
    width: 100%;
    padding: 8px 0;
    background-color: #fff;
    z-index: 999;
    box-shadow: 0 -2px 4px 0 rgba(0, 0, 0, 0.05);
  }
  //button style
  button {
    display: block;
    color: #fff;
    margin: 0 auto;
    background-color: #d93f30;
    height: 34px;
    line-height: 34px;
    border-radius: 17px;
    width: 80%;
    border: none;
    font-size: 15px;
    text-align: center;
  }
</style>