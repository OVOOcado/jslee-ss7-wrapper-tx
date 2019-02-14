/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.map.tx.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;
import org.mobicents.protocols.ss7.map.api.service.callhandling.ExtendedRoutingInfo;
import org.mobicents.protocols.ss7.map.api.service.callhandling.RoutingInfo;

import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxExtendedRoutingInfoWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxIMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxRoutingInfoWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSendRoutingInfoResponseWrapper;


/**
 * The Class TxSendRoutingInfoResponseWrapperTest.
 */
public class TxSendRoutingInfoResponseWrapperTest extends WrapperBaseTest {

    /** The tx send routing info response wrapper. */
    TxSendRoutingInfoResponseWrapper txSendRoutingInfoResponseWrapper;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        txSendRoutingInfoResponseWrapper = new TxSendRoutingInfoResponseWrapper();
        IMSI imsi = mapParameterFactory.createIMSI("260345678897567");
        TxIMSIAddressWrapper txIMSIAddressWrapper = new TxIMSIAddressWrapper(imsi);
        txSendRoutingInfoResponseWrapper.setImsi(txIMSIAddressWrapper);
        ISDNAddressString addressString = mapParameterFactory.createISDNAddressString(
                AddressNature.international_number, NumberingPlan.land_mobile, "0048678987345");
        RoutingInfo routingInfo = mapParameterFactory.createRoutingInfo(addressString);
        ExtendedRoutingInfo extendedroutingInfo = mapParameterFactory.createExtendedRoutingInfo(routingInfo);
        TxExtendedRoutingInfoWrapper txExtendedRoutingInfoWrapper = new TxExtendedRoutingInfoWrapper(extendedroutingInfo);
        txSendRoutingInfoResponseWrapper.setExtendedRoutingInfo(txExtendedRoutingInfoWrapper);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest#testSerialization()
     */
    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {
        serializeToFile(txSendRoutingInfoResponseWrapper);
        TxSendRoutingInfoResponseWrapper tx = (TxSendRoutingInfoResponseWrapper) deserializeFromFile();

        assertTrue(txSendRoutingInfoResponseWrapper.getImsi().getAddress().equals(tx.getImsi().getAddress()));
        assertTrue(txSendRoutingInfoResponseWrapper.getTxImsi().getData().equals(tx.getTxImsi().getData()));
        assertTrue(txSendRoutingInfoResponseWrapper.getExtendedRoutingInfo().getRoutingInfo().getNatureOfAddress().getValue() == tx
                .getExtendedRoutingInfo().getRoutingInfo().getNatureOfAddress().getValue());
        assertTrue(txSendRoutingInfoResponseWrapper.getExtendedRoutingInfo().getRoutingInfo().getNumberingPlan().getValue() == tx
                .getExtendedRoutingInfo().getRoutingInfo().getNumberingPlan().getValue());
        assertTrue(txSendRoutingInfoResponseWrapper.getExtendedRoutingInfo().getRoutingInfo().getRoamingNumber()
                .equals(tx.getExtendedRoutingInfo().getRoutingInfo().getRoamingNumber()));
        assertTrue(((TxRoutingInfoWrapper)txSendRoutingInfoResponseWrapper.getExtendedRoutingInfo().getRoutingInfo()).getTxRoutingInfo().getRoamingNumber().getAddress()
                .equals(((TxRoutingInfoWrapper)tx.getExtendedRoutingInfo().getRoutingInfo()).getTxRoutingInfo().getRoamingNumber().getAddress()));

    }

}
