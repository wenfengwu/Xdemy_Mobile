<template>
  <div class="c_wapper">
    <div class="course">
      <div class="l_img">
        <img :src="videoInfo.cover_img" :title="videoInfo.title" />
      </div>

      <div class="r_txt">
        <div class="txt">
          <span>Total Rating:</span>
          <p>{{ videoInfo.point }}</p>
        </div>

        <div class="txt">
          <span>Price:</span>
          <p>${{ videoInfo.price / 100 }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {

  props: {
    videoInfo: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style lang="scss" scoped>

    .c_wrapper {
        padding: 0 14px;
    }

    .course {
        margin: 14px 0;
        display: flex; 
    }

    .l_img {
        height: 88px;
        margin-right: 14px;
    & img {
        height: 100%;
        border-radius: 15px;
    }
    }

    .r_txt {
        padding: 6px 0;
        font-size: 15px;
        flex: 1; 
    }

    .txt {

        display: flex;
        justify-content: space-between;
        line-height: 16px;
        margin-bottom: 1em;
    & p {
        text-align: center;
        width: 40%;
        color: #3bb149;
    }
    & i {
        color: #666;
        font-weight: bolder;
        width: 60%;
        & span {
        color: #2b333b;
        font-size: 12px;
        }
    }
    }
</style>