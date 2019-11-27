<template>
  <el-button :size="size" :type="type" :icon="icon" :loading="loading" :disabled="!hasPerms(perms)" @click="handleClick">
    {{ label }}
  </el-button>
</template>

<script>
import { hasPermission } from '../../utils/permission'

export default {
  name: 'KtButton',
  data () {
    return {}
  },
  props: {
    label: { // 按钮显示文本
      type: String,
      default: 'Button'
    },
    icon: { // 按钮显示图标
      type: String,
      default: ''
    },
    size: { // 按钮尺寸
      type: String,
      default: 'mini'
    },
    type: { // 按钮类型
      type: String,
      default: null
    },
    loading: { // 是否在加载中
      type: Boolean,
      default: false
    },
    disabled: { // 按钮是否禁用
      type: Boolean,
      default: false
    },
    perms: { // 按钮权限标识
      type: String,
      default: null
    }
  },
  methods: {
    handleClick () {
      // 按钮事件操处理函数
      this.$emit('click', {})
    },
    hasPerms (perms) {
      // 根据外部传入的权限标识和外部指示状态进行权限判断
      return hasPermission(perms)
    }
  }
}
</script>

<style scoped>

</style>
