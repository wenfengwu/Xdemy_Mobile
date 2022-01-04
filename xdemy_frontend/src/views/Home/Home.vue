<template>
  <div>
    <!--Carousel-->
    <home-carousel :carousel = "carousel"></home-carousel>

    <video-list :videoList = "videoList"> </video-list>

    <common-footer></common-footer>
  </div>
</template>


<script>
//@ is root direction
import HomeCarousel from "./Components/Carousel";
import VideoList from "./Components/VideoList";
import CommonFooter from "@/components/CommonFooter";
import { getCarousel, getVideoList } from "@/api/getData.js";

export default {
  //register component
  components: {
    HomeCarousel,
    VideoList,
    CommonFooter,
  },
  //data source, usage like useState
  data() {
    return {
      carousel: [],
      videoList: [],
    };
  },

  methods: {
    // get data of Carousel
    async getCarouselData() {
      try {
        const result = await getCarousel();
        if (result.data.code == 0) {
          this.carousel = result.data.data;
          console.log(this.carousel);
        }
      } catch (error) {
        console.log(error);
      }
    },

    //get video list
    async getVideoListData() {
      try {
        const result = await getVideoList();
        if (result.data.code == 0) {
          this.videoList = result.data.data;
          console.log(this.videoList);
        }
      } catch (error) {
        console.log(error);
      }
    },
  },
  mounted() {
    //get data when web rendered
    this.getCarouselData();
    this.getVideoListData();
  },
};
</script>


<style lang="scss" scope>
</style>