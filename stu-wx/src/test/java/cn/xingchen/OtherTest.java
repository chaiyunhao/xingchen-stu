package cn.xingchen;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;

public class OtherTest {

    @Test
    public void getUserInfo() {


        String json = "{\"total\":166,\"count\":166,\"data\":{\"openid\":[\"otHK3wGtKYZCs656YL6akyv8M6WA\",\"otHK3wFO9RtsK29wqb5jN97GWm1U\",\"otHK3wJbeXJRwmC8FwDwbDE56Gzc\",\"otHK3wAEj6iEnHYISoYDNVJqMB4s\",\"otHK3wOUJBjHZ0ieeS74wG-1vqzs\",\"otHK3wMYL91KvgpuIhLoHLdOKWTo\",\"otHK3wCWCZ62U4F8PW_P2QvYf864\",\"otHK3wMcFsWS53cseK23eDuP8OtQ\",\"otHK3wGh5XGF2SB6gBgXEpRuWl90\",\"otHK3wIhduxyw31liNtcupCTK2ZU\",\"otHK3wIbbz-zuL4ZU_6k0eClkGiI\",\"otHK3wDxvcP-MonbsXbuNJ-pSEOk\",\"otHK3wED2Hi_i2vKzGaZTJHc8ml4\",\"otHK3wGRKA34NaHNxl48jK7UtXHM\",\"otHK3wCVGt-MXrkkTiEObcpZDfEU\",\"otHK3wIPQY_julX0nWkMADNZ8MnQ\",\"otHK3wNdKAZtBP_qJ2Z2gk4M07lE\",\"otHK3wApfdemU9zbU6keM9YFikCc\",\"otHK3wERujn6mKc6NWbHnDRF0_94\",\"otHK3wJ-u9K1ljXKLQ2nbC9E96TY\",\"otHK3wAZqk75ae3neKGuTMbNBL9w\",\"otHK3wHTfAIVmjfR6ZX-8hoMmako\",\"otHK3wBUza8v-JezqIKMj40DsQZg\",\"otHK3wDcyV_pNKYBVf9dNISCHuls\",\"otHK3wKq-ZfkmbPiqGJGq2p3NZOg\",\"otHK3wLqXgs8tB3NuipLnkCdBdK0\",\"otHK3wLsg9bRb1WVwoUhi2q-xBC4\",\"otHK3wGZw5rhvmd2CCpnBvQJ0FTc\",\"otHK3wLFB6A3k2yLZ4ukFC_Rgrwo\",\"otHK3wCYVmtIlWSHHQlJ3SEf5d94\",\"otHK3wFygxYwMHuHl1vXG5jT-tw8\",\"otHK3wBO3T6ZO0tXbpA8vnBTV4vE\",\"otHK3wMOAPrIGnNskIgxKwxgFrwU\",\"otHK3wHA4gwrnom0epUbg3iyLWuI\",\"otHK3wC53Oy8iqOfuqib1juJBZb4\",\"otHK3wJ39xF9WITqQiDGbjwmJWO4\",\"otHK3wMaxVz6FrTVVUaEkxxIYWCs\",\"otHK3wGdjwmSu0tfnJ4W-jOfYMy8\",\"otHK3wItjwmT2LvwE-sKkZexmk0E\",\"otHK3wBHHtoDAl5WF7mo8WczfpOM\",\"otHK3wLiFCzCxEQXF-5cIPNtmbUg\",\"otHK3wLUIPv4iUQvjxFZQrxBJ4Hg\",\"otHK3wEdMx1Q1ma0FOBKW9MrO4Bk\",\"otHK3wFUOLat46dZZ5yhvlolDg24\",\"otHK3wLiA3_iwpMa-99SXbk_6wGk\",\"otHK3wAlRmnLGFEuzLwH4eByfToI\",\"otHK3wKDcARJtiCRbzTNuQvl_RIg\",\"otHK3wJy-TRl7HANb_jOXfDr3ZqA\",\"otHK3wAjFD2KClJdhHymhwEYcz5o\",\"otHK3wKWYR9qEayc-UuionBebSgw\",\"otHK3wJ5VuAk-XsuCjXK2xQbRKKw\",\"otHK3wKQwRBZ6kNMU_Nc6etqYE2k\",\"otHK3wMl8CyFIcN5wNd5_5PA3MXc\",\"otHK3wCz_9khcElqzE3dbHMmeIdc\",\"otHK3wDUVtwVLkW4R05Wp6X_tmes\",\"otHK3wGTJx4416YGjaxH0MZCkhJI\",\"otHK3wPdd-RLcS9mqIzl8MVPEC8g\",\"otHK3wPKIjCbAaXTWiXOHYMT5XFY\",\"otHK3wKcsxg1cs0MZWCmOb-jg0s0\",\"otHK3wFQLSV9fxRspBrXwEyhMU0U\",\"otHK3wJzBqTehqWe0sWYMLgAW8po\",\"otHK3wBIAIwWGjSJX5VQNvP5KlmY\",\"otHK3wFo850T48KdVC0WOCEVrcxY\",\"otHK3wB5FiJn4H7Yjeq8AL6P4rfQ\",\"otHK3wEAN_D2NRvX8GOLBbRUviuM\",\"otHK3wGAKtCiRD3XC1zcXhIEJQno\",\"otHK3wGYQiWeFYv8nBgYyRUM8Eps\",\"otHK3wPyJUauJTZMpC60zSQHd1qE\",\"otHK3wFKD2GLac4zQatZLmh0WuM4\",\"otHK3wECmkHt5udgew6CvOZDK-w8\",\"otHK3wDfL4UpVHGeNmmWOVnnhBxI\",\"otHK3wAvnk_3HoAsti_7tDfGQHnI\",\"otHK3wF-D4YFdh1JC65bS6Mlj3sg\",\"otHK3wDdzqZMd6AykCbm3eAeEIlU\",\"otHK3wDUBxfhycNtyP1yuw-eRhik\",\"otHK3wNUnuQOe6b_9Nn5fQ_NUnvY\",\"otHK3wF5tm1n0a-n9YW1HwklZIXM\",\"otHK3wPoyRQNzAbspMADUL-Ncuz4\",\"otHK3wI8bZxCARI7i3u_-66fp1vQ\",\"otHK3wHR1VND61WcKAPzCdrRyZs8\",\"otHK3wHSVu2DED7HHDHGRFWnlmdw\",\"otHK3wOIlQBcTNjppSvCM6ICKJWk\",\"otHK3wO_NuHdRubBu1x8cl8azF-c\",\"otHK3wK8R4gs1L_4-SLx6ufFRTeY\",\"otHK3wDOYn-c5Zg1XAfj6Ns4mOS4\",\"otHK3wDvVrqiesol4KMocmE7zM20\",\"otHK3wOzsoQ5uA4Ik4Dl5Ufd8gFk\",\"otHK3wJV8cjn6nfrbmQLJN6y5ng4\",\"otHK3wIAin4BpNXXyij8UZLlRv34\",\"otHK3wDQpDcCeAYIdOejv0SNX82k\",\"otHK3wFhXLgMrnHjwISQjI317NBE\",\"otHK3wGY69vScVYu9D5XkqNIkZNw\",\"otHK3wCKjZoTtdC8myVl0qkvfINE\",\"otHK3wN67SfcH3DPPAKONQ_n8a90\",\"otHK3wO-zXd6D95uO3I4V_xAN6Gw\",\"otHK3wGdu4T3RCxCmtGdfkdfGjSw\",\"otHK3wHGOpgeW7TJ2cUWbL7OFGOg\",\"otHK3wGQsig1LkVmU0VetuhiRHEI\",\"otHK3wE4eQ43zL_q7fgnp-CcV-ak\",\"otHK3wDNGoFug3aOD9_PdqGXQxa0\",\"otHK3wCnTombkrsYdpi_uw4qCKck\",\"otHK3wOt8tY6xmeY6UcTA9e2cYQA\",\"otHK3wLhRxwGsTreqL6bq-j-RR20\",\"otHK3wKFD96-6jSiNzUd9ALGz7vA\",\"otHK3wExrNC8ECcDkIlEP2llHt0w\",\"otHK3wFHGeUK0ohymXU6KX-CPW3w\",\"otHK3wE9fADQvGnHbaK_TEgt5Tuc\",\"otHK3wJiabhAW9TgfuX6yzyFyZaY\",\"otHK3wMreRQa0JjweM6b3Pc3FZH4\",\"otHK3wK09otj6GaKktHQWUvNgFII\",\"otHK3wDLxZO8cb7Gm-6CVJ24oqto\",\"otHK3wJm2KRPxMroUFJJP6_dSZHo\",\"otHK3wKICFfCPzGLVxxFG6_Kmhs4\",\"otHK3wPgRdXdLUFlk2pELbPItnO0\",\"otHK3wNdXEWcV_tyltRRufFiJVRU\",\"otHK3wPo3gUshpRwAGubz1VFOYXY\",\"otHK3wPP4Lnupv3FBYFMw-n4rFr8\",\"otHK3wI6aZE4WWeVxrxAjvlWAL7I\",\"otHK3wAUBk2jrwcdnm4vs307PlwU\",\"otHK3wNlo9XYtd_5jX-2ORX05gsg\",\"otHK3wOH5DD1VA9MKtyxs5-3TBlk\",\"otHK3wDQ-d4Yw_YQH8Wfy7Q5n9uk\",\"otHK3wI0NvoFOwcNE0-ZtLodq8zs\",\"otHK3wD0ut1TjeWF0goQ8Eeo57qs\",\"otHK3wPge419yutwFtq6gvexPvKk\",\"otHK3wIbJ57mX7M6dqne4s1vi1Dg\",\"otHK3wPHXi4kwLHdVx2Oz_Kl54aA\",\"otHK3wCvbcHCDKr9nZKBDL5OZnTs\",\"otHK3wLPEgnKUVTbhPW4_4rqvHEg\",\"otHK3wLjrUwt46tyLV4FtS6xm-PI\",\"otHK3wBLA5lJCgr6LudGPYCOO2HE\",\"otHK3wG7cp7j-ylYX7qnbeBrV_OE\",\"otHK3wIBgpr23RInFjfFh5Wb7GJI\",\"otHK3wADaRjOYC7T14Aq0Bobspnk\",\"otHK3wD7XjVDFSaA7h01YgDhZN0o\",\"otHK3wOtAejUb7hwaxfUcJ6LBmCw\",\"otHK3wJJXbIKAkaPiiv_9e2Z6vHw\",\"otHK3wPzQL2as3l8-uOi_UTbLKzQ\",\"otHK3wMBlqjO74s6pr1Mft5N7kOA\",\"otHK3wH2uRXRCVCdgzeMuFFh7Gic\",\"otHK3wAqt3w2H7wCefLW_2_0iaPk\",\"otHK3wEMIYSXSmLXKENscx0LaqTU\",\"otHK3wCdzc1Sv9pCP8ywk7u5HcIk\",\"otHK3wN-yJTBSgqlMfi5c_QOW4FE\",\"otHK3wCoH9630s9c1kQrE_mVNz1c\",\"otHK3wCeHNVk0FMASKFyfoEFOX_E\",\"otHK3wF-VWYbCyzt5jYjBbJlcxFc\",\"otHK3wO429Lq6DqbI0Zd6L9FKo0s\",\"otHK3wD8UhFpp7x7Ew-lFq_YL9nw\",\"otHK3wP1VUTESbhkRJuekt-PFyPA\",\"otHK3wEtM6IGQ8O2L1mWs_mVXn3I\",\"otHK3wHxTZZD8OBinRsgf3ZH7C-w\",\"otHK3wL2gTSqHzkmzRy4tnD78auw\",\"otHK3wDXoj0epMZc7iIZvN4-Y2mg\",\"otHK3wH0FlgM-eqv5ciKRtGHT3qY\",\"otHK3wGkXVXCApQgBDNVq8LbBR_8\",\"otHK3wKGxX9y61r0KULrRxu1CX2o\",\"otHK3wNTvw2QFJZYrc3IzwRVPjVU\",\"otHK3wJDs-ADw-7MhQziAMnCelis\",\"otHK3wFN_xa944ts6xojbf-wVVTE\",\"otHK3wDsgOHwr2kmAGN3AGV5l75g\",\"otHK3wGMfA1F6cUKt5n7jf54bFkQ\",\"otHK3wH5hoLmbbHL6Zw7CGPfyuEg\",\"otHK3wLDZnlvQzk-sIcapeWkxZVE\",\"otHK3wFDvtxmKWVxcY9GpDI7YGSE\",\"otHK3wOVVk0d6V--DhsbleLpKSKw\"]},\"next_openid\":\"otHK3wOVVk0d6V--DhsbleLpKSKw\"}";

        //创建json解析器
        JsonParser parse =new JsonParser();
        //创建jsonObject对象
        JsonObject jsonObj=(JsonObject) parse.parse(json);

        String dataStr =jsonObj.get("data").toString();

        JsonObject dataObj=(JsonObject) parse.parse(dataStr);

        JsonArray jsonArray =dataObj.get("openid").getAsJsonArray();

        for(JsonElement jsonElement:jsonArray){
            System.out.println(jsonElement.getAsString());
        }

    }

}
