package cn.xingchen.list

/**
 * @author  chaiyunhao
 * @date  2020/11/7 23:30
 */
class Solution_1 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            val solution = Solution_1();
            solution.twoSum(intArrayOf(2, 7, 11, 15), 9)
        }
    }


    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for((index, value) in nums.withIndex()){
            val temp = map[target - value]
            if(null != temp){
                return intArrayOf(temp, index);
            }else{
                map[value] = index;
            }
            println(map)
        }

        return intArrayOf()
    }
}