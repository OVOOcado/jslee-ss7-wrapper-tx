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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.EsiBcsm.OCalledPartyBusySpecificInfo;
import org.mobicents.protocols.ss7.cap.api.EsiBcsm.ODisconnectSpecificInfo;
import org.mobicents.protocols.ss7.cap.api.EsiBcsm.RouteSelectFailureSpecificInfo;
import org.mobicents.protocols.ss7.cap.api.EsiBcsm.TBusySpecificInfo;
import org.mobicents.protocols.ss7.cap.api.EsiBcsm.TDisconnectSpecificInfo;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.EventSpecificInformationBCSM;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper;


/**
 * TxEventSpecificInformationBCSMWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxEventSpecificInformationBCSMWrapper implements EventSpecificInformationBCSMWrapper {

    /** The tx event specific information bcsm. */
    private final EventSpecificInformationBCSM txEventSpecificInformationBCSM;

    /**
     * Instantiates a new tx event specific information bcsm wrapper.
     *
     * @param eventSpecificInformationBCSM the event specific information bcsm
     */
    public TxEventSpecificInformationBCSMWrapper(final EventSpecificInformationBCSM eventSpecificInformationBCSM) {
        this.txEventSpecificInformationBCSM = eventSpecificInformationBCSM;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper#isTCalledPartyBusySpecificInfoChosen()
     */
    @Override
    public boolean isTCalledPartyBusySpecificInfoChosen() {
        return txEventSpecificInformationBCSM.getTBusySpecificInfo() != null &&
                txEventSpecificInformationBCSM.getRouteSelectFailureSpecificInfo() == null &&
        txEventSpecificInformationBCSM.getOCalledPartyBusySpecificInfo() == null &&
        txEventSpecificInformationBCSM.getONoAnswerSpecificInfo() == null &&
        txEventSpecificInformationBCSM.getOAnswerSpecificInfo() == null &&
        txEventSpecificInformationBCSM.getOMidCallSpecificInfo() == null &&
        txEventSpecificInformationBCSM.getODisconnectSpecificInfo() == null &&
        txEventSpecificInformationBCSM.getTNoAnswerSpecificInfo() == null &&
        txEventSpecificInformationBCSM.getTAnswerSpecificInfo() == null &&
        txEventSpecificInformationBCSM.getTMidCallSpecificInfo() == null &&
        txEventSpecificInformationBCSM.getTDisconnectSpecificInfo() == null &&
        txEventSpecificInformationBCSM.getOTermSeizedSpecificInfo() == null &&
        txEventSpecificInformationBCSM.getCallAcceptedSpecificInfo() == null &&
        txEventSpecificInformationBCSM.getOAbandonSpecificInfo() == null &&
        txEventSpecificInformationBCSM.getOChangeOfPositionSpecificInfo() == null &&
        txEventSpecificInformationBCSM.getTChangeOfPositionSpecificInfo() == null &&
        txEventSpecificInformationBCSM.getDpSpecificInfoAlt() == null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper#isOCalledPartyBusySpecificInfoChosen()
     */
    @Override
    public boolean isOCalledPartyBusySpecificInfoChosen() {
        return txEventSpecificInformationBCSM.getTBusySpecificInfo() == null &&
                txEventSpecificInformationBCSM.getRouteSelectFailureSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOCalledPartyBusySpecificInfo() != null &&
                txEventSpecificInformationBCSM.getONoAnswerSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOAnswerSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOMidCallSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getODisconnectSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getTNoAnswerSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getTAnswerSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getTMidCallSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getTDisconnectSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOTermSeizedSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getCallAcceptedSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOAbandonSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOChangeOfPositionSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getTChangeOfPositionSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getDpSpecificInfoAlt() == null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper#isTDisconnectSpecificInfoChosen()
     */
    @Override
    public boolean isTDisconnectSpecificInfoChosen() {
        return txEventSpecificInformationBCSM.getTBusySpecificInfo() == null &&
                txEventSpecificInformationBCSM.getRouteSelectFailureSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOCalledPartyBusySpecificInfo() == null &&
                txEventSpecificInformationBCSM.getONoAnswerSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOAnswerSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOMidCallSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getODisconnectSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getTNoAnswerSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getTAnswerSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getTMidCallSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getTDisconnectSpecificInfo() != null &&
                txEventSpecificInformationBCSM.getOTermSeizedSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getCallAcceptedSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOAbandonSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOChangeOfPositionSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getTChangeOfPositionSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getDpSpecificInfoAlt() == null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper#isODisconnectSpecificInfoChosen()
     */
    @Override
    public boolean isODisconnectSpecificInfoChosen() {
        return txEventSpecificInformationBCSM.getTBusySpecificInfo() == null &&
                txEventSpecificInformationBCSM.getRouteSelectFailureSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOCalledPartyBusySpecificInfo() == null &&
                txEventSpecificInformationBCSM.getONoAnswerSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOAnswerSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOMidCallSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getODisconnectSpecificInfo() != null &&
                txEventSpecificInformationBCSM.getTNoAnswerSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getTAnswerSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getTMidCallSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getTDisconnectSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOTermSeizedSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getCallAcceptedSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOAbandonSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOChangeOfPositionSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getTChangeOfPositionSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getDpSpecificInfoAlt() == null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper#isRouteSelectFailureSpecificInfoChosen()
     */
    @Override
    public boolean isRouteSelectFailureSpecificInfoChosen() {
        return txEventSpecificInformationBCSM.getTBusySpecificInfo() == null &&
                txEventSpecificInformationBCSM.getRouteSelectFailureSpecificInfo() != null &&
                txEventSpecificInformationBCSM.getOCalledPartyBusySpecificInfo() == null &&
                txEventSpecificInformationBCSM.getONoAnswerSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOAnswerSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOMidCallSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getODisconnectSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getTNoAnswerSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getTAnswerSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getTMidCallSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getTDisconnectSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOTermSeizedSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getCallAcceptedSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOAbandonSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getOChangeOfPositionSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getTChangeOfPositionSpecificInfo() == null &&
                txEventSpecificInformationBCSM.getDpSpecificInfoAlt() == null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper#getTCalledPartyBusySpecificInfo()
     */
    @Override
    public TCalledPartyBusySpecificInfoWrapper getTCalledPartyBusySpecificInfo() {
        if (txEventSpecificInformationBCSM.getTBusySpecificInfo() != null) {
            return new TxTCalledPartyBusySpecificInfoWrapper(txEventSpecificInformationBCSM.getTBusySpecificInfo());
        }
        return null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper#getOCalledPartyBusySpecificInfo()
     */
    @Override
    public OCalledPartyBusySpecificInfoWrapper getOCalledPartyBusySpecificInfo() {
        if (txEventSpecificInformationBCSM.getOCalledPartyBusySpecificInfo() != null) {
            return new TxOCalledPartyBusySpecificInfoWrapper(txEventSpecificInformationBCSM.getOCalledPartyBusySpecificInfo());
        }
        return null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper#getTDisconnectSpecificInfo()
     */
    @Override
    public TDisconnectSpecificInfoWrapper getTDisconnectSpecificInfo() {
        if (txEventSpecificInformationBCSM.getTDisconnectSpecificInfo() != null) {
            return new TxTDisconnectSpecificInfoWrapper(txEventSpecificInformationBCSM.getTDisconnectSpecificInfo());
        }
        return null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper#getODisconnectSpecificInfo()
     */
    @Override
    public ODisconnectSpecificInfoWrapper getODisconnectSpecificInfo() {
        if (txEventSpecificInformationBCSM.getODisconnectSpecificInfo() != null) {
            return new TxODisconnectSpecificInfoWrapper(txEventSpecificInformationBCSM.getODisconnectSpecificInfo());
        }
        return null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper#getRouteSelectFailureSpecificInfo()
     */
    @Override
    public RouteSelectFailureSpecificInfoWrapper getRouteSelectFailureSpecificInfo() {
        if (txEventSpecificInformationBCSM.getRouteSelectFailureSpecificInfo() != null) {
            return new TxRouteSelectFailureSpecificInfoWrapper(txEventSpecificInformationBCSM.getRouteSelectFailureSpecificInfo());
        }
        return null;
    }

    /**
     * Gets the tx event specific information bcsm.
     *
     * @return the tx event specific information bcsm
     */
    public EventSpecificInformationBCSM getTxEventSpecificInformationBCSM() {
        return txEventSpecificInformationBCSM;
    }

    /**
     * The Class TxTCalledPartyBusySpecificInfoWrapper.
     */
    public static class TxTCalledPartyBusySpecificInfoWrapper implements TCalledPartyBusySpecificInfoWrapper {

        /** The t called party busy specific info. */
        protected final TBusySpecificInfo tCalledPartyBusySpecificInfo;

        /**
         * Instantiates a new tx t called party busy specific info wrapper.
         *
         * @param tCalledPartyBusySpecificInfo the t called party busy specific info
         */
        public TxTCalledPartyBusySpecificInfoWrapper(final TBusySpecificInfo tCalledPartyBusySpecificInfo) {
            this.tCalledPartyBusySpecificInfo = tCalledPartyBusySpecificInfo;
        }

        /* (non-Javadoc)
         * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper.TCalledPartyBusySpecificInfoWrapper#hasBusyCause()
         */
        @Override
        public boolean hasBusyCause() throws Ss7WrapperException {
            try {
                return tCalledPartyBusySpecificInfo.getBusyCause() != null && tCalledPartyBusySpecificInfo.getBusyCause().getCauseIndicators() != null;
            } catch (CAPException e) {
                throw new Ss7WrapperException(e);
            }
        }

        /* (non-Javadoc)
         * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper.TCalledPartyBusySpecificInfoWrapper#getBusyCause()
         */
        @Override
        public CauseWrapper getBusyCause() throws Ss7WrapperException {
            try {
                if (tCalledPartyBusySpecificInfo.getBusyCause() != null && tCalledPartyBusySpecificInfo.getBusyCause().getCauseIndicators() != null) {
                    return new TxCauseWrapper(tCalledPartyBusySpecificInfo.getBusyCause().getCauseIndicators());
                }
                return null;
            } catch (CAPException e) {
                throw new Ss7WrapperException(e);
            }

        }

        /**
         * Gets the tx t called party busy specific info.
         *
         * @return the tx t called party busy specific info
         */
        public TBusySpecificInfo getTxTCalledPartyBusySpecificInfo() {
            return tCalledPartyBusySpecificInfo;
        }
    }

    /**
     * The Class TxOCalledPartyBusySpecificInfoWrapper.
     */
    public static class TxOCalledPartyBusySpecificInfoWrapper implements OCalledPartyBusySpecificInfoWrapper {

        /** The t called party busy specific info. */
        private final OCalledPartyBusySpecificInfo tCalledPartyBusySpecificInfo;

        /**
         * Instantiates a new tx o called party busy specific info wrapper.
         *
         * @param tCalledPartyBusySpecificInfo the t called party busy specific info
         */
        public TxOCalledPartyBusySpecificInfoWrapper(final OCalledPartyBusySpecificInfo tCalledPartyBusySpecificInfo) {
            this.tCalledPartyBusySpecificInfo = tCalledPartyBusySpecificInfo;
        }

        /* (non-Javadoc)
         * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper.OCalledPartyBusySpecificInfoWrapper#hasBusyCause()
         */
        @Override
        public boolean hasBusyCause() throws Ss7WrapperException {
            try {
                return tCalledPartyBusySpecificInfo.getBusyCause() != null && tCalledPartyBusySpecificInfo.getBusyCause().getCauseIndicators() != null;
            } catch (CAPException e) {
                throw new Ss7WrapperException(e);
            }
        }

        /* (non-Javadoc)
         * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper.OCalledPartyBusySpecificInfoWrapper#getBusyCause()
         */
        @Override
        public CauseWrapper getBusyCause() throws Ss7WrapperException {
            try {
                if (tCalledPartyBusySpecificInfo.getBusyCause() != null && tCalledPartyBusySpecificInfo.getBusyCause().getCauseIndicators() != null) {
                    return new TxCauseWrapper(tCalledPartyBusySpecificInfo.getBusyCause().getCauseIndicators());
                }
                return null;
            } catch (CAPException e) {
                throw new Ss7WrapperException(e);
            }

        }
    }


    /**
     * The Class TxTDisconnectSpecificInfoWrapper.
     */
    public static class TxTDisconnectSpecificInfoWrapper implements TDisconnectSpecificInfoWrapper {

        /** The t disconnect specific info. */
        private final TDisconnectSpecificInfo tDisconnectSpecificInfo;

        /**
         * Instantiates a new tx t disconnect specific info wrapper.
         *
         * @param tDisconnectSpecificInfo the t disconnect specific info
         */
        public TxTDisconnectSpecificInfoWrapper(final TDisconnectSpecificInfo tDisconnectSpecificInfo) {
            this.tDisconnectSpecificInfo = tDisconnectSpecificInfo;
        }

        /* (non-Javadoc)
         * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper.TDisconnectSpecificInfoWrapper#hasReleaseCause()
         */
        @Override
        public boolean hasReleaseCause() throws Ss7WrapperException {
            try {
                return tDisconnectSpecificInfo.getReleaseCause() != null && tDisconnectSpecificInfo.getReleaseCause().getCauseIndicators() != null;
            } catch (CAPException e) {
                throw new Ss7WrapperException(e);
            }
        }

        /* (non-Javadoc)
         * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper.TDisconnectSpecificInfoWrapper#getReleaseCause()
         */
        @Override
        public CauseWrapper getReleaseCause() throws Ss7WrapperException {
            try {
                if (tDisconnectSpecificInfo.getReleaseCause() != null && tDisconnectSpecificInfo.getReleaseCause().getCauseIndicators() != null) {
                    return new TxCauseWrapper(tDisconnectSpecificInfo.getReleaseCause().getCauseIndicators());
                }
                return null;
            } catch (CAPException e) {
                throw new Ss7WrapperException(e);
            }

        }
    }

    /**
     * The Class TxODisconnectSpecificInfoWrapper.
     */
    public static class TxODisconnectSpecificInfoWrapper implements ODisconnectSpecificInfoWrapper {

        /** The o disconnect specific info. */
        private final ODisconnectSpecificInfo oDisconnectSpecificInfo;

        /**
         * Instantiates a new tx o disconnect specific info wrapper.
         *
         * @param oDisconnectSpecificInfo the o disconnect specific info
         */
        public TxODisconnectSpecificInfoWrapper(final ODisconnectSpecificInfo oDisconnectSpecificInfo) {
            this.oDisconnectSpecificInfo = oDisconnectSpecificInfo;
        }

        /* (non-Javadoc)
         * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper.ODisconnectSpecificInfoWrapper#hasReleaseCause()
         */
        @Override
        public boolean hasReleaseCause() throws Ss7WrapperException {
            try {
                return oDisconnectSpecificInfo.getReleaseCause() != null && oDisconnectSpecificInfo.getReleaseCause().getCauseIndicators() != null;
            } catch (CAPException e) {
                throw new Ss7WrapperException(e);
            }
        }

        /* (non-Javadoc)
         * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper.ODisconnectSpecificInfoWrapper#getReleaseCause()
         */
        @Override
        public CauseWrapper getReleaseCause() throws Ss7WrapperException {
            try {
                if (oDisconnectSpecificInfo.getReleaseCause() != null && oDisconnectSpecificInfo.getReleaseCause().getCauseIndicators() != null) {
                    return new TxCauseWrapper(oDisconnectSpecificInfo.getReleaseCause().getCauseIndicators());
                }
                return null;
            } catch (CAPException e) {
                throw new Ss7WrapperException(e);
            }

        }
    }


    /**
     * The Class TxRouteSelectFailureSpecificInfoWrapper.
     */
    public static class TxRouteSelectFailureSpecificInfoWrapper implements RouteSelectFailureSpecificInfoWrapper {

        /** The route select failure specific info. */
        private final RouteSelectFailureSpecificInfo routeSelectFailureSpecificInfo;

        /**
         * Instantiates a new tx route select failure specific info wrapper.
         *
         * @param routeSelectFailureSpecificInfo the route select failure specific info
         */
        public TxRouteSelectFailureSpecificInfoWrapper(final RouteSelectFailureSpecificInfo routeSelectFailureSpecificInfo) {
            this.routeSelectFailureSpecificInfo = routeSelectFailureSpecificInfo;
        }

        /* (non-Javadoc)
         * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper.RouteSelectFailureSpecificInfoWrapper#hasFailureCause()
         */
        @Override
        public boolean hasFailureCause() throws Ss7WrapperException {
            try {
                return routeSelectFailureSpecificInfo.getFailureCause() != null && routeSelectFailureSpecificInfo.getFailureCause().getCauseIndicators() != null;
            } catch (CAPException e) {
                throw new Ss7WrapperException(e);
            }
        }

        /* (non-Javadoc)
         * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper.RouteSelectFailureSpecificInfoWrapper#getFailureCause()
         */
        @Override
        public CauseWrapper getFailureCause() throws Ss7WrapperException {
            try {
                if (routeSelectFailureSpecificInfo.getFailureCause() != null && routeSelectFailureSpecificInfo.getFailureCause().getCauseIndicators() != null) {
                    return new TxCauseWrapper(routeSelectFailureSpecificInfo.getFailureCause().getCauseIndicators());
                }
                return null;
            } catch (CAPException e) {
                throw new Ss7WrapperException(e);
            }

        }
    }
}
