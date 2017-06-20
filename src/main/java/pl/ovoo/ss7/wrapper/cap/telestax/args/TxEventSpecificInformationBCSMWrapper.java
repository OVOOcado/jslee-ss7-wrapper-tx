/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.EsiBcsm.OCalledPartyBusySpecificInfo;
import org.mobicents.protocols.ss7.cap.api.EsiBcsm.ODisconnectSpecificInfo;
import org.mobicents.protocols.ss7.cap.api.EsiBcsm.RouteSelectFailureSpecificInfo;
import org.mobicents.protocols.ss7.cap.api.EsiBcsm.TBusySpecificInfo;
import org.mobicents.protocols.ss7.cap.api.EsiBcsm.TDisconnectSpecificInfo;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.EventSpecificInformationBCSM;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.CauseWrapper;
import pl.ovoo.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper;

/**
 * TxEventSpecificInformationBCSMWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxEventSpecificInformationBCSMWrapper implements EventSpecificInformationBCSMWrapper {

    private final EventSpecificInformationBCSM txEventSpecificInformationBCSM;

    public TxEventSpecificInformationBCSMWrapper(final EventSpecificInformationBCSM eventSpecificInformationBCSM) {
        this.txEventSpecificInformationBCSM = eventSpecificInformationBCSM;
    }

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

    @Override
    public TCalledPartyBusySpecificInfoWrapper getTCalledPartyBusySpecificInfo() {
        if (txEventSpecificInformationBCSM.getTBusySpecificInfo() != null) {
            return new TxTCalledPartyBusySpecificInfoWrapper(txEventSpecificInformationBCSM.getTBusySpecificInfo());
        }
        return null;
    }

    @Override
    public OCalledPartyBusySpecificInfoWrapper getOCalledPartyBusySpecificInfo() {
        if (txEventSpecificInformationBCSM.getOCalledPartyBusySpecificInfo() != null) {
            return new TxOCalledPartyBusySpecificInfoWrapper(txEventSpecificInformationBCSM.getOCalledPartyBusySpecificInfo());
        }
        return null;
    }

    @Override
    public TDisconnectSpecificInfoWrapper getTDisconnectSpecificInfo() {
        if (txEventSpecificInformationBCSM.getTDisconnectSpecificInfo() != null) {
            return new TxTDisconnectSpecificInfoWrapper(txEventSpecificInformationBCSM.getTDisconnectSpecificInfo());
        }
        return null;
    }

    @Override
    public ODisconnectSpecificInfoWrapper getODisconnectSpecificInfo() {
        if (txEventSpecificInformationBCSM.getODisconnectSpecificInfo() != null) {
            return new TxODisconnectSpecificInfoWrapper(txEventSpecificInformationBCSM.getODisconnectSpecificInfo());
        }
        return null;
    }

    @Override
    public RouteSelectFailureSpecificInfoWrapper getRouteSelectFailureSpecificInfo() {
        if (txEventSpecificInformationBCSM.getRouteSelectFailureSpecificInfo() != null) {
            return new TxRouteSelectFailureSpecificInfoWrapper(txEventSpecificInformationBCSM.getRouteSelectFailureSpecificInfo());
        }
        return null;
    }

    public EventSpecificInformationBCSM getTxEventSpecificInformationBCSM() {
        return txEventSpecificInformationBCSM;
    }

    public static class TxTCalledPartyBusySpecificInfoWrapper implements TCalledPartyBusySpecificInfoWrapper {

        protected final TBusySpecificInfo tCalledPartyBusySpecificInfo;

        public TxTCalledPartyBusySpecificInfoWrapper(final TBusySpecificInfo tCalledPartyBusySpecificInfo) {
            this.tCalledPartyBusySpecificInfo = tCalledPartyBusySpecificInfo;
        }

        @Override
        public boolean hasBusyCause() throws Ss7WrapperException {
            try {
                return tCalledPartyBusySpecificInfo.getBusyCause() != null && tCalledPartyBusySpecificInfo.getBusyCause().getCauseIndicators() != null;
            } catch (CAPException e) {
                throw new Ss7WrapperException(e);
            }
        }

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

        public TBusySpecificInfo getTxTCalledPartyBusySpecificInfo() {
            return tCalledPartyBusySpecificInfo;
        }
    }

    public static class TxOCalledPartyBusySpecificInfoWrapper implements OCalledPartyBusySpecificInfoWrapper {

        private final OCalledPartyBusySpecificInfo tCalledPartyBusySpecificInfo;

        public TxOCalledPartyBusySpecificInfoWrapper(final OCalledPartyBusySpecificInfo tCalledPartyBusySpecificInfo) {
            this.tCalledPartyBusySpecificInfo = tCalledPartyBusySpecificInfo;
        }

        @Override
        public boolean hasBusyCause() throws Ss7WrapperException {
            try {
                return tCalledPartyBusySpecificInfo.getBusyCause() != null && tCalledPartyBusySpecificInfo.getBusyCause().getCauseIndicators() != null;
            } catch (CAPException e) {
                throw new Ss7WrapperException(e);
            }
        }

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


    public static class TxTDisconnectSpecificInfoWrapper implements TDisconnectSpecificInfoWrapper {

        private final TDisconnectSpecificInfo tDisconnectSpecificInfo;

        public TxTDisconnectSpecificInfoWrapper(final TDisconnectSpecificInfo tDisconnectSpecificInfo) {
            this.tDisconnectSpecificInfo = tDisconnectSpecificInfo;
        }

        @Override
        public boolean hasReleaseCause() throws Ss7WrapperException {
            try {
                return tDisconnectSpecificInfo.getReleaseCause() != null && tDisconnectSpecificInfo.getReleaseCause().getCauseIndicators() != null;
            } catch (CAPException e) {
                throw new Ss7WrapperException(e);
            }
        }

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

    public static class TxODisconnectSpecificInfoWrapper implements ODisconnectSpecificInfoWrapper {

        private final ODisconnectSpecificInfo oDisconnectSpecificInfo;

        public TxODisconnectSpecificInfoWrapper(final ODisconnectSpecificInfo oDisconnectSpecificInfo) {
            this.oDisconnectSpecificInfo = oDisconnectSpecificInfo;
        }

        @Override
        public boolean hasReleaseCause() throws Ss7WrapperException {
            try {
                return oDisconnectSpecificInfo.getReleaseCause() != null && oDisconnectSpecificInfo.getReleaseCause().getCauseIndicators() != null;
            } catch (CAPException e) {
                throw new Ss7WrapperException(e);
            }
        }

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


    public static class TxRouteSelectFailureSpecificInfoWrapper implements RouteSelectFailureSpecificInfoWrapper {

        private final RouteSelectFailureSpecificInfo routeSelectFailureSpecificInfo;

        public TxRouteSelectFailureSpecificInfoWrapper(final RouteSelectFailureSpecificInfo routeSelectFailureSpecificInfo) {
            this.routeSelectFailureSpecificInfo = routeSelectFailureSpecificInfo;
        }

        @Override
        public boolean hasFailureCause() throws Ss7WrapperException {
            try {
                return routeSelectFailureSpecificInfo.getFailureCause() != null && routeSelectFailureSpecificInfo.getFailureCause().getCauseIndicators() != null;
            } catch (CAPException e) {
                throw new Ss7WrapperException(e);
            }
        }

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
