<template>
  <div class="main">
    <cube-form :model="model" @submit="submitHandler">
      <cube-form-group>

        <cube-form-item :field="fields[0]"></cube-form-item>

        <cube-form-item :field="fields[1]"></cube-form-item>

        <cube-form-item :field="fields[2]"></cube-form-item>
      </cube-form-group>

      <cube-form-group>
        <cube-button type="submit">Register</cube-button>
      </cube-form-group>
    </cube-form>
    <router-link to="/login" class="reg">Login</router-link>
  </div>
</template>

<script>
import { registerApi } from "@/api/getData.js";
export default {
  data() {
    return {
      model: {
        phoneValue: "",
        pwdValue: "",
        nameValue: "",
      },
      fields: [
        {
          type: "input",
          modelKey: "nameValue",
          label: "User",
          props: {
            placeholder: "Please Enter User Name",
          },
          rules: {
            required: true,
          },
          messages: {
            required: "User Name is Required",
          },
        },
        {
          type: "input",
          modelKey: "phoneValue",
          label: "Phone",
          props: {
            placeholder: "Please Enter Phone Number",
          },
          rules: {
            required: true,
          },
          messages: {
            required: "Phone Number is Required",
          },
        },
        {
          type: "input",
          modelKey: "pwdValue",
          label: "Password",
          props: {
            placeholder: "Please Enter Password",
            type: "password",
            //set visionable or not
            eye: {
              open: false,
            },
          },
          rules: {
            required: true,
          },
          messages: {
            required: "Password is Required",
          },
        },
      ],
    };
  },
  methods: {
    submitHandler(e, model) {
      e.preventDefault();
      //Invoke register API
      registerApi(model.phoneValue, model.pwdValue, model.nameValue).then(
        (res) => {
          if (res.data.code === 0) {
            const toast = this.$createToast({
              txt: "Successful!!",
              type: "correct",
              time: 1500,
            });
            toast.show();
          }
        }
      );
    },
  },
};
</script>

<style lang="scss" scoped>
    .main {
        padding: 50px 5% 0;
        text-align: center;
    }
    //Register button
    .cube-btn {
        margin-top: 20px;
    }
    //Longin button
    .reg {
        display: inline-block;
        margin-top: 30px;
        font-size: 18px;
    }
</style>