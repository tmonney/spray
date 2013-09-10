/*
 * Copyright © 2011-2013 the spray project <http://spray.io>
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

package spray.util
package pimps

import org.specs2.mutable.Specification
import java.io.ByteArrayInputStream

class PimpedInputStreamSpec extends Specification {

  "toByteArrayStream" should {
    "properly chunk an inputstream" in {
      val is = new ByteArrayInputStream("This is not a particularly long text".getBytes)
      is.toByteArrayStream(8).map(_.asString).mkString("|") === "This is |not a pa|rticular|ly long |text"
    }
  }

}