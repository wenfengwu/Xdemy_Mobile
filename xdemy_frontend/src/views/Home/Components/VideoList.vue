<template>
  <div class="list-content">
    <div class="list">
      <!--traverse each course-->
      <router-link
        :key="item.id"
        :to="{ path: '/coursedetail', query: { video_id: item.id } }"
        class="course"
        v-for="item in videoList"
      >
        <div class="item_img">
          <img :src="item.cover_img" />
        </div>
        <div class="video_info">
          <div class="c_title">{{ item.title }}</div>
          <div class="price">$ {{ item.price / 100 }}</div>
        </div>
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    videoList: {
      type: Array,
      required: true,
    },
  },
};
</script>

<style lang="scss" scoped>
    //course margin
    .list-content {
        margin-top: 20px;
        padding: 0 13px;
        }
    //course frame
    .list {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
        padding-bottom: 55px;
    }
    //each course
    .course {
        width: 48%;
        margin-bottom: 17px;
    }
    //course image
    .item_img {
        font-size: 0;
        box-shadow: 0 4px 11px 0 rgba(43, 51, 59, 0.6); //set shadoe of box
        border-radius: 8px;
        img {
            width: 100%;
            border-radius: 8px;
        }
    }
    .c_title {
    //hidden setting start and end
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 2;
        overflow: hidden;
        word-break: break-all;

        font-size: 11px;
        height: 26px;
        line-height: 13px;
        margin-top: 10px;
        color: #2b333b;
    }

    .price {
        margin-top: 8px;
        font-size: 12px;
        color: #d93f30;
    }
</style>