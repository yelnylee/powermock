/*
 * Copyright 2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package samples.junit4.suppressconstructor;

import org.junit.Test;
import org.powermock.reflect.Whitebox;
import samples.suppressconstructor.SuppressNonParentConstructorDemo;

import static org.junit.Assert.assertEquals;

public class SuppressNonParentConstructorDemoTest {

	@Test
	public void testNewInstanceWithoutInvokingConstructor() throws Exception {
		SuppressNonParentConstructorDemo constructorDemo = Whitebox
				.newInstance(SuppressNonParentConstructorDemo.class);
		assertEquals("Hello", constructorDemo.getHello());
	}

	@Test(expected = IllegalStateException.class)
	public void testNewInstanceInvokingConstructor() throws Exception {
		new SuppressNonParentConstructorDemo("failing");
	}

}
