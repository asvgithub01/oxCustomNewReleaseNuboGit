/*
 * Created by Orchextra
 *
 * Copyright (C) 2016 Gigigo Mobile Services SL
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gigigo.com.orchextra.data.datasources.db;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmDefaultInstance {

    public synchronized Realm createRealmInstance(Context context) {

        RealmConfiguration config =
                new RealmConfiguration.Builder(context)
                        .deleteRealmIfMigrationNeeded()
                        .name("oxnew2.realm")
                        .schemaVersion(4)
                        .modules(new OrchextraRealmModule())
                        .build();

        return Realm.getInstance(config);
    }

    public static int getNextKey(Realm realm, Class classType) {
        try {
            return realm.where(classType).max("id").intValue() + 1;
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            return 1;
        }
    }
}